package no.nav.pensjon.innsyn.controller

import no.nav.pensjon.innsyn.service.WorksheetProducer
import no.nav.security.token.support.core.api.Unprotected
import org.apache.poi.xssf.streaming.SXSSFWorkbook
import org.springframework.http.HttpHeaders.CONTENT_DISPOSITION
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.*
import javax.servlet.http.HttpServletResponse

@Unprotected //@Protected
@RestController
@RequestMapping("/innsyn")
class InnsynController(val worksheetProducer: WorksheetProducer) {

    @GetMapping("/POPP")
    fun getInnsyn(@RequestHeader("pid") pid: Int, response: HttpServletResponse) {
        response.apply {
            addHeader("Content-Description", "File Transfer")
            addHeader(CONTENT_DISPOSITION, contentDisposition)
            addHeader("Content-Transfer-Encoding", "binary")
            addHeader("Connection", "Keep-Alive")
            contentType = CONTENT_TYPE_EXCEL
            SXSSFWorkbook(worksheetProducer.producePOPPWorksheet(pid)).write(outputStream)
        }
    }

    companion object {
        const val CONTENT_TYPE_EXCEL = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
        private val DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd")
        private val contentDisposition: String
            get() = "attachment; filename=POPP-${DATE_FORMAT.format(Date())}"
    }
}