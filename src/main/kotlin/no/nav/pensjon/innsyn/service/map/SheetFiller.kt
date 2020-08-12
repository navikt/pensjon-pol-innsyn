package no.nav.pensjon.innsyn.service.map

import no.nav.pensjon.innsyn.entity.DomainContainer
import org.apache.poi.ss.usermodel.*

/**
 * Adapted from
 * https://www.callicoder.com/java-write-excel-file-apache-poi/
 */
class SheetFiller<T> internal constructor(
        private val container: DomainContainer<T>
) {
    private val sheetName = container.entityName
    private val columns = container.propertyNames
    fun populateSheet(pid: Int, workbook: Workbook) {
        val sheet = workbook.createSheet(sheetName)
        createHeaderRow(sheet, createHeaderCellStyle(workbook))
        createRows(pid, sheet, createDateCellStyle(workbook))
        fitColumnsToContentSize(sheet)
    }

    private fun createRows(pid: Int, sheet: Sheet, dateCellStyle: CellStyle) {
        container.repository.findAllByPersonId(pid).forEachIndexed { i, e ->
            container.rowFiller(RowFiller(sheet, dateCellStyle, i + 1), e)
        }
    }

    private fun createHeaderRow(sheet: Sheet, cellStyle: CellStyle) {
        createCells(sheet.createRow(0), cellStyle)
    }

    private fun createCells(row: Row, cellStyle: CellStyle) {
        (0..columns.size).forEach { createCell(row, it, cellStyle) }
    }

    private fun createCell(row: Row, index: Int, style: CellStyle) {
        row.createCell(index).apply {
            setCellValue(columns[index])
            cellStyle = style
        }
    }

    private fun fitColumnsToContentSize(sheet: Sheet) {
        (0..columns.size).forEach(sheet::autoSizeColumn)
    }

    companion object {
        private const val DATE_FORMAT = "dd-MM-yyyy"
        private fun createHeaderCellStyle(workbook: Workbook) = workbook.createCellStyle().apply {
            setFont(createHeaderFont(workbook))
        }

        private fun createDateCellStyle(workbook: Workbook) = workbook.createCellStyle().apply {
            dataFormat = workbook.creationHelper.createDataFormat().getFormat(DATE_FORMAT)
        }

        private fun createHeaderFont(workbook: Workbook) = workbook.createFont().apply {
            bold = true
            fontHeightInPoints = 14
            color = IndexedColors.RED.getIndex()
        }
    }

}