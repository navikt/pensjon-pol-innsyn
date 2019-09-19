package no.nav.pensjon.innsyn.server.auth;

import no.nav.pensjon.innsyn.server.http.Headers;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebFilter(filterName="BasicAuth", urlPatterns={"/innsyn"}, servletNames={"InnsynServlet"})
public class BasicAuth extends HttpFilter {

    private static final String AUTH_TYPE = "Basic";
    private static final String USERNAME_PASSWORD_SEPARATOR = ":";
    private static final int CREDENTIALS_START_INDEX = AUTH_TYPE.length() + 1;
    private static final int HTTP_STATUS_UNAUTHORIZED = 401;
    private static final int USERNAME_INDEX = 0;
    private static final int PASSWORD_INDEX = 1;

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String auth = request.getHeader(Headers.AUTH);
        if (!(auth == null || auth.length() < CREDENTIALS_START_INDEX)) {

            var credentialBytes = decode(auth.substring(CREDENTIALS_START_INDEX));
            if (!(credentialBytes == null || credentialBytes.length < 1)) {

                String[] credentials = new String(credentialBytes).split(USERNAME_PASSWORD_SEPARATOR);
                if (credentials[USERNAME_INDEX].equals("postgres") && credentials[PASSWORD_INDEX].equals("docker")){
                    chain.doFilter(request, response);
                    return;
                }
            }
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
