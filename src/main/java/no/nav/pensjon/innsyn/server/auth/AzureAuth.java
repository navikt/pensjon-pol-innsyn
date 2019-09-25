package no.nav.pensjon.innsyn.server.auth;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.nav.pensjon.aad.auth.Server;
import no.nav.pensjon.innsyn.server.http.Headers;

@WebFilter(filterName = "AzureAuth", urlPatterns = {"/innsyn"}, servletNames = {"InnsynServlet"})
public class AzureAuth extends HttpFilter {

    private static final String AUTH_TYPE = "Bearer";
    private static final int HTTP_STATUS_UNAUTHORIZED = 401;
    private static final Server aad = new Server();

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException {
        String auth = request.getHeader(Headers.AUTH);
        try {
            var valid = aad.validateAuthorizationHeader(auth);
            if (valid) {
                chain.doFilter(request, response);
                return;
            }
        } catch (Exception ignored) {
        }
        challenge(response);
        response.sendError(HTTP_STATUS_UNAUTHORIZED, "Invalid authentication.");
    }

    private static void challenge(HttpServletResponse response) {
        response.setStatus(HTTP_STATUS_UNAUTHORIZED);
        response.setHeader(Headers.CHALLENGE, AUTH_TYPE);
    }

    private static byte[] decode(String value) {
        try {
            return Base64.getDecoder().decode(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public void destroy() {
    }
}
