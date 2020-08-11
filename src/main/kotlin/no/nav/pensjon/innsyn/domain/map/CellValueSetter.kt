package no.nav.pensjon.innsyn.domain.map

import java.util.*

interface CellValueSetter {
    fun setCellValue(cellIndex: Int, value: Boolean)
    fun setCellValue(cellIndex: Int, value: Date)
    fun setCellValue(cellIndex: Int, value: Double)
    fun setCellValue(cellIndex: Int, value: String)
}