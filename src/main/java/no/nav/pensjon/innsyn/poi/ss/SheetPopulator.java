package no.nav.pensjon.innsyn.poi.ss;

import org.apache.poi.ss.usermodel.Workbook;

public interface SheetPopulator {

    void populateSheet(Workbook workbook);
}
