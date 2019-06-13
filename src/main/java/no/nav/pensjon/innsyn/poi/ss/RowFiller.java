package no.nav.pensjon.innsyn.poi.ss;

import no.nav.pensjon.innsyn.sink.CellValueSetter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Date;

public class RowFiller implements CellValueSetter {

    private final CellStyle dateCellStyle;
    private final Row row;

    RowFiller(Sheet sheet, CellStyle dateCellStyle, int rowIndex) {
        this.dateCellStyle = dateCellStyle;
        this.row = sheet.createRow(rowIndex);
    }

    public void setCellValue(int cellIndex, double value) {
        row.createCell(cellIndex).setCellValue(value);
    }

    public void setCellValue(int cellIndex, String value) {
        row.createCell(cellIndex).setCellValue(value);
    }

    public void setCellValue(int cellIndex, Date value) {
        createDateCell(cellIndex).setCellValue(value);
    }

    private Cell createCell(int cellIndex) {
        return row.createCell(cellIndex);
    }

    private Cell createDateCell(int cellIndex) {
        Cell cell = createCell(cellIndex);
        cell.setCellStyle(dateCellStyle);
        return cell;
    }
}
