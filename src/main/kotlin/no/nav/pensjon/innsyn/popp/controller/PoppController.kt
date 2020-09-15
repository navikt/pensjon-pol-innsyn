package no.nav.pensjon.innsyn.popp.controller

import no.nav.pensjon.innsyn.common.CONTENT_TYPE_EXCEL
import no.nav.pensjon.innsyn.popp.service.PoppSheetProducer
import no.nav.security.token.support.core.api.Protected
import org.apache.poi.xssf.streaming.SXSSFWorkbook
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.*
import javax.servlet.http.HttpServletResponse

@Protected
@RestController
@RequestMapping("/innsyn")
class PoppController(private val worksheetProducer: PoppSheetProducer) {

    private val contentDisposition: String
        get() = "attachment; filename=POPP-${SimpleDateFormat("yyyy-MM-dd").format(Date())}"

    @GetMapping
    fun getPoppInnsyn(@RequestHeader("fnr") fnr: String, response: HttpServletResponse) {
        response.apply {
            addHeader("Content-Description", "File Transfer")
            addHeader(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
            addHeader("Content-Transfer-Encoding", "binary")
            addHeader("Connection", "Keep-Alive")
            contentType = CONTENT_TYPE_EXCEL
            SXSSFWorkbook(worksheetProducer.produceWorksheet(fnr)).write(outputStream)
        }
    }
}