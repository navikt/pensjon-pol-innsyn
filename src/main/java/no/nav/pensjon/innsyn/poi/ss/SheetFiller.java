package no.nav.pensjon.innsyn.poi.ss;

import no.nav.pensjon.innsyn.entity.EntitySupport;
import no.nav.pensjon.innsyn.sink.CellValueSetter;
import no.nav.pensjon.innsyn.source.EntityGetter;
import org.apache.poi.ss.usermodel.*;

import java.util.function.BiConsumer;
import java.util.stream.IntStream;

/**
 * Adapted from
 * https://www.callicoder.com/java-write-excel-file-apache-poi/
 */
public class SheetFiller<T> implements SheetPopulator {

    private final static String DATE_FORMAT = "dd-MM-yyyy";
    private final String sheetName;
    private final String[] columns;
    private final EntityGetter<T> entityGetter;
    private final BiConsumer<CellValueSetter, T> createRow;

    SheetFiller(EntitySupport<T> support) {
        this.sheetName = support.getEntityDescriptor().getEntityName();
        this.columns = support.getEntityDescriptor().getPropertyNames();
        this.entityGetter = support.getEntityGetter();
        this.createRow = support.getCreateRow();
    }

    public void populateSheet(Workbook workbook) {
        Sheet sheet = workbook.createSheet(sheetName);
        createHeaderRow(sheet, createHeaderCellStyle(workbook));
        createRows(sheet, createDateCellStyle(workbook));
        fitColumnsToContentSize(sheet);
    }

    private void createRows(Sheet sheet, CellStyle dateCellStyle) {
        int rowIndex = 1;

        for (T entity : entityGetter.getEntities()) {
            createRow.accept(new RowFiller(sheet, dateCellStyle, rowIndex++), entity);
        }
    }

    private void createHeaderRow(Sheet sheet, CellStyle cellStyle) {
        Row row = sheet.createRow(0);
        createCells(row, cellStyle);
    }

    private void createCells(Row row, CellStyle cellStyle) {
        IntStream.range(0, columns.length).forEach(i -> createCell(row, i, cellStyle));
    }

    private void createCell(Row row, int index, CellStyle style) {
        Cell cell = row.createCell(index);
        cell.setCellValue(columns[index]);
        cell.setCellStyle(style);
    }

    private void fitColumnsToContentSize(Sheet sheet) {
        IntStream.range(0, columns.length).forEach(sheet::autoSizeColumn);
    }

    private static CellStyle createHeaderCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setFont(createHeaderFont(workbook));
        return style;
    }

    private static CellStyle createDateCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat(DATE_FORMAT));
        return style;
    }

    private static Font createHeaderFont(Workbook workbook) {
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 14);
        font.setColor(IndexedColors.RED.getIndex());
        return font;
    }
}
