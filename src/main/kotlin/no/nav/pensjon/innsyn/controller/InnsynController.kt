package no.nav.pensjon.innsyn.controller

import no.nav.pensjon.innsyn.service.WorksheetProducer
import no.nav.security.token.support.core.api.Protected
import no.nav.security.token.support.core.api.Unprotected
import org.apache.poi.xssf.streaming.SXSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpHeaders.CONTENT_DISPOSITION
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.BufferedOutputStream
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.*
import javax.servlet.http.HttpServletResponse

@Unprotected
@RestController
@RequestMapping("/innsyn")
class InnsynController(val worksheetProducer: WorksheetProducer) {

    @GetMapping("/POPP")
    fun getInnsyn(@RequestHeader("pid") pid: Int, response: HttpServletResponse) {
        response.apply {
            SXSSFWorkbook(worksheetProducer.producePOPPWorksheet(pid)).write(outputStream)
            addHeader(CONTENT_DISPOSITION, contentDisposition)
            contentType = CONTENT_TYPE_EXCEL
            flushBuffer()
        }
    }

    companion object {
        private const val FILE_NAME = "innsyn.%s.xlsx"
        const val CONTENT_TYPE_EXCEL = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
        private val DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd")
        private val contentDisposition: String
            get() = "attachment; filename=${FILE_NAME.format(DATE_FORMAT.format(Date()))}"
    }
}