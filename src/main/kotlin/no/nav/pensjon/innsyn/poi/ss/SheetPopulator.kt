package no.nav.pensjon.innsyn.poi.ss

import org.apache.poi.ss.usermodel.Workbook

interface SheetPopulator {
    fun populateSheet(workbook: Workbook)
}