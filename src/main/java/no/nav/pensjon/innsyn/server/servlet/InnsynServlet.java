package no.nav.pensjon.innsyn.server.servlet;

import no.nav.pensjon.innsyn.server.http.Headers;
import no.nav.pensjon.innsyn.sink.ServletOutputStreamCreator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static no.nav.pensjon.innsyn.main.WorksheetProducer.produceWorksheet;

@WebServlet(name = "InnsynServlet", urlPatterns = {"/innsyn"}, loadOnStartup = 1)
public class InnsynServlet extends HttpServlet {

    private static final String QUERY_PARAMETER_NAME = "fnr";
    private static final String FILE_NAME = "innsyn.%s.xlsx";
    private static final String CONTENT_TYPE_EXCEL = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private static final int FNR_START_INDEX = QUERY_PARAMETER_NAME.length() + 1;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String queryString = request.getQueryString();
        if (queryString == null) response.sendError(400,"Missing query.");
        else {
            String fnr = queryString.substring(FNR_START_INDEX);
            response.setContentType(CONTENT_TYPE_EXCEL);
            response.setHeader(Headers.CONTENT_DISPOSITION, getContentDisposition());
            produceWorksheet(fnr, new ServletOutputStreamCreator(response));
        }
    }

    private static String getContentDisposition() {
        String date = DATE_FORMAT.format(new Date());
        return "attachment; filename=" + String.format(FILE_NAME, date);
    }
}
