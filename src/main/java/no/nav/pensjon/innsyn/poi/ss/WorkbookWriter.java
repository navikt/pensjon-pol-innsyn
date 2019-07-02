package no.nav.pensjon.innsyn.poi.ss;

import no.nav.pensjon.innsyn.sink.OutputStreamCreator;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

class WorkbookWriter {

    static void createFile(WorkbookCreator workbookCreator,
                           List<SheetPopulator> sheetPopulators,
                           OutputStreamCreator outputStreamCreator) throws IOException {
        try (Workbook workbook = workbookCreator.createWorkbook()) {
            sheetPopulators.forEach(o -> o.populateSheet(workbook));
            writeToFile(workbook, outputStreamCreator);
        }
    }

    private static void writeToFile(Workbook workbook, OutputStreamCreator outputStreamCreator) throws IOException {
        try (OutputStream output = outputStreamCreator.create()) {
            workbook.write(output);
        }
    }
}