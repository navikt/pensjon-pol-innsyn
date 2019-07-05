package no.nav.pensjon.innsyn.server.auth;

import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BasicAuthTest {

    private static String CORRECT_USERNAME = "postgres";
    private static String CORRECT_PASSWORD = "docker";
    private static String HEADER_NAME = "Authorization";

    @Test
    void hasBasicAuth_correctCredentials() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader(HEADER_NAME)).thenReturn(basicAuth(CORRECT_USERNAME, CORRECT_PASSWORD));
        assertTrue(BasicAuth.hasBasicAuth(request));
    }

    @Test
    void hasBasicAuth_emptyRequest() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        assertFalse(BasicAuth.hasBasicAuth(request));
    }

    @Test
    void hasBasicAuth_incorrectPassword() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader(HEADER_NAME)).thenReturn(basicAuth(CORRECT_USERNAME, "incorrect"));
        assertFalse(BasicAuth.hasBasicAuth(request));
    }

    @Test
    void hasBasicAuth_incorrectUsername() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader(HEADER_NAME)).thenReturn(basicAuth("incorrect", CORRECT_PASSWORD));
        assertFalse(BasicAuth.hasBasicAuth(request));
    }

    @Test
    void hasBasicAuth_invalidBase64Value() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader(HEADER_NAME)).thenReturn("Basic cG9zdGdyZXM6ZG9ja2VyMg=");
        assertFalse(BasicAuth.hasBasicAuth(request));
    }

    @Test
    void hasBasicAuth_wrongAuthType() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader(HEADER_NAME)).thenReturn("Bearer " + correctCredentials());
        assertFalse(BasicAuth.hasBasicAuth(request));
    }

    @Test
    void hasBasicAuth_invalidAuthType() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader(HEADER_NAME)).thenReturn("Invalid " + correctCredentials());
        assertFalse(BasicAuth.hasBasicAuth(request));
    }

    @Test
    void hasBasicAuth_noAuthType() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader(HEADER_NAME)).thenReturn(correctCredentials());
        assertFalse(BasicAuth.hasBasicAuth(request));
    }

    @Test
    void hasBasicAuth_noHeaderValue() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader(HEADER_NAME)).thenReturn("");
        assertFalse(BasicAuth.hasBasicAuth(request));
    }

    private static String basicAuth(String username, String password) {
        return "Basic " + credentials(username, password);
    }

    private static String credentials(String username, String password) {
        return Base64.getEncoder().encodeToString(String.format("%s:%s", username, password).getBytes());
    }

    private static String correctCredentials() {
        return credentials(CORRECT_USERNAME, CORRECT_PASSWORD);
    }
}
