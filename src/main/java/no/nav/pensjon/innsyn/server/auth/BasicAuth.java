package no.nav.pensjon.innsyn.server.auth;

import no.nav.pensjon.innsyn.server.http.Headers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

public class BasicAuth {

    private static final String AUTH_TYPE = "Basic";
    private static final String USERNAME_PASSWORD_SEPARATOR = ":";
    private static final int CREDENTIALS_START_INDEX = AUTH_TYPE.length() + 1;
    private static final int HTTP_STATUS_UNAUTHORIZED = 401;
    private static final int USERNAME_INDEX = 0;
    private static final int PASSWORD_INDEX = 1;

    public static boolean hasBasicAuth(HttpServletRequest request) {
        String auth = request.getHeader(Headers.AUTH);

        if (auth == null || auth.length() < CREDENTIALS_START_INDEX) {
            return false;
        }

        String base64Credentials = auth.substring(CREDENTIALS_START_INDEX);
        byte[] decodedCredentials = decode(base64Credentials);

        if (decodedCredentials == null || decodedCredentials.length < 1) {
            return false;
        }

        String[] credentials = new String(decodedCredentials).split(USERNAME_PASSWORD_SEPARATOR);
        return credentials[USERNAME_INDEX].equals("postgres") && credentials[PASSWORD_INDEX].equals("docker");
    }

    public static void challenge(HttpServletResponse response) {
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
}
