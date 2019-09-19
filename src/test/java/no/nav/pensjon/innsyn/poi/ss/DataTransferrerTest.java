package no.nav.pensjon.innsyn.poi.ss;

import no.nav.pensjon.innsyn.entity.EntityDescriptor;
import no.nav.pensjon.innsyn.entity.EntitySupport;
import no.nav.pensjon.innsyn.sink.CellValueSetter;
import no.nav.pensjon.innsyn.sink.OutputStreamCreator;
import no.nav.pensjon.innsyn.source.EntityGetter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DataTransferrerTest {

    static final String FILE_NAME = "test-worksheet.xlsx";
    private static final int MIN_NUMBER_OF_EXCEL_WORKBOOK_BYTES = 3000;
    private WorkbookCreator workbookCreator;
    private OutputStreamCreator streamCreator;
    private List<EntitySupport<?>> entitySupports;

    @BeforeEach
    void setUp() {
        EntityGetter<Domain1> source = () -> List.of(new Domain1());
        BiConsumer<CellValueSetter, Domain1> sink = (s, d) -> s.setCellValue(0, d.property1);
        EntityDescriptor descriptor = mock(EntityDescriptor.class);
        workbookCreator = mock(WorkbookCreator.class);
        streamCreator = mock(OutputStreamCreator.class);
        entitySupports = List.of(new EntitySupport<>(source, descriptor, sink));
        when(descriptor.getEntityName()).thenReturn("sheet1");
        when(descriptor.getPropertyNames()).thenReturn(new String[]{"col1"});
    }

    @Test
    void transferEntitiesToWorkbook_mock() throws IOException {
        var workbook = mock(Workbook.class);
        var sheet = mock(Sheet.class);
        var row = mock(Row.class);
        var creationHelper = mock(CreationHelper.class);
        var byteStream = new ByteArrayOutputStream();
        when(workbookCreator.createWorkbook()).thenReturn(workbook);
        when(workbook.createFont()).thenReturn(mock(Font.class));
        when(workbook.createCellStyle()).thenReturn(mock(CellStyle.class));
        when(workbook.getCreationHelper()).thenReturn(creationHelper);
        when(workbook.createSheet("sheet1")).thenReturn(sheet);
        when(sheet.createRow(anyInt())).thenReturn(row);
        when(row.createCell(0)).thenReturn(mock(Cell.class));
        when(creationHelper.createDataFormat()).thenReturn(mock(DataFormat.class));
        when(streamCreator.create()).thenReturn(byteStream);
        Answer<String> answer = invocation -> {
            ((ByteArrayOutputStream) invocation.getArgument(0)).write("hello".getBytes(StandardCharsets.UTF_8));
            return null;
        };
        doAnswer(answer).when(workbook).write(byteStream);

        DataTransferrer.transferEntitiesToWorkbook(entitySupports, workbookCreator, streamCreator);

        assertEquals("hello", new String(byteStream.toByteArray()));
    }

    @Test
    void transferEntitiesToWorkbook_excel_bytes() throws IOException {
        var byteStream = new ByteArrayOutputStream();
        when(workbookCreator.createWorkbook()).thenReturn(new XSSFWorkbook());
        when(streamCreator.create()).thenReturn(byteStream);

        DataTransferrer.transferEntitiesToWorkbook(entitySupports, workbookCreator, streamCreator);

        // Tolerate a certain length variation between runs:
        assertTrue(byteStream.toByteArray().length >= MIN_NUMBER_OF_EXCEL_WORKBOOK_BYTES);
    }

    @Test
    void transferEntitiesToWorkbook_excel_file() throws IOException {
        when(workbookCreator.createWorkbook()).thenReturn(new XSSFWorkbook());
        when(streamCreator.create()).thenReturn(new FileOutputStream(FILE_NAME));

        DataTransferrer.transferEntitiesToWorkbook(entitySupports, workbookCreator, streamCreator);

        var file = new File(FILE_NAME);
        assertTrue(file.exists());
        assertEquals("hello", getCellValue(0));
        assertTrue(file.delete());
        assertFalse(file.exists());
    }

    static String getCellValue(int cellIndex) throws IOException {
        try (var workbook = WorkbookFactory.create(new File(FILE_NAME))) {
            var sheet = workbook.getSheetAt(0);
            var row = sheet.getRow(1);
            var cell = row.getCell(cellIndex);
            return cell.getStringCellValue();
        }
    }

    private static class Domain1 {

        final String property1 = "hello";
    }
}
