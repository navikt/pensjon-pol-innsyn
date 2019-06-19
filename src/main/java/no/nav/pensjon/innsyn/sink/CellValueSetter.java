package no.nav.pensjon.innsyn.sink;

import java.util.Date;

public interface CellValueSetter {

    void setCellValue(int cellIndex, boolean value);

    void setCellValue(int cellIndex, Date value);

    void setCellValue(int cellIndex, double value);

    void setCellValue(int cellIndex, String value);
}
