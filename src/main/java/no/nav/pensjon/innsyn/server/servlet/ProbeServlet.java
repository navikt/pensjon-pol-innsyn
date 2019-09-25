package no.nav.pensjon.innsyn.server.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ProbeServlet", urlPatterns = {"/isReady", "/isAlive"}, loadOnStartup = 1)
public class ProbeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setContentType("application/json");
        try (ServletOutputStream out = response.getOutputStream()) {
            out.write("{\"status\":\"UP\"}".getBytes());
            out.flush();
        }
    }
}