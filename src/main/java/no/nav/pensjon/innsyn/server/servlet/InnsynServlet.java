package no.nav.pensjon.innsyn.server.servlet;

import no.nav.pensjon.innsyn.sink.ServletOutputStreamCreator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static no.nav.pensjon.innsyn.main.WorksheetProducer.produceWorksheet;

@WebServlet(name = "InnsynServlet", urlPatterns = {"/innsyn"})
public class InnsynServlet extends HttpServlet {

    private static final String FILE_NAME = "innsyn.%s.xlsx";
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String date = new SimpleDateFormat(DATE_PATTERN).format(new Date());
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-disposition", "attachment; filename=" + String.format(FILE_NAME, date));
        produceWorksheet("01029312345", new ServletOutputStreamCreator(response));
    }
}
