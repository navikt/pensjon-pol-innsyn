package no.nav.pensjon.innsyn.poi.xssf;

import no.nav.pensjon.innsyn.poi.ss.WorkbookCreator;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWorkbookCreator implements WorkbookCreator {

    /**
     * XSSF = XML SpreadSheet Format; supports Office Open XML (XLSX) format files
     */
    @Override
    public Workbook createWorkbook() {
        return new XSSFWorkbook();
    }
}
