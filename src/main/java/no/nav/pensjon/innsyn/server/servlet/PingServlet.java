package no.nav.pensjon.innsyn.server.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PingServlet", urlPatterns = {"/ping"}, loadOnStartup = 1)
public class PingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (ServletOutputStream out = response.getOutputStream()) {
            out.write("pong".getBytes());
            out.flush();
        }
    }
}
