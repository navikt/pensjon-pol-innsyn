package no.nav.pensjon.innsyn.poi.ss

import no.nav.pensjon.innsyn.domain.map.CellValueSetter
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.Sheet
import java.util.*

class RowFiller internal constructor(sheet: Sheet, private val dateCellStyle: CellStyle, rowIndex: Int) : CellValueSetter {
    private val row = sheet.createRow(rowIndex)
    override fun setCellValue(cellIndex: Int, value: Boolean) {
        row.createCell(cellIndex).setCellValue(if (value) "ja" else "nei")
    }

    override fun setCellValue(cellIndex: Int, value: Double) {
        row.createCell(cellIndex).setCellValue(value)
    }

    override fun setCellValue(cellIndex: Int, value: String) {
        row.createCell(cellIndex).setCellValue(value)
    }

    override fun setCellValue(cellIndex: Int, value: Date) {
        createDateCell(cellIndex).setCellValue(value)
    }

    private fun createCell(cellIndex: Int) = row.createCell(cellIndex)

    private fun createDateCell(cellIndex: Int) = createCell(cellIndex).apply { cellStyle = dateCellStyle }

}