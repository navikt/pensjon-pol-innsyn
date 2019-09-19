package no.nav.pensjon.innsyn.server.auth;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Stubber;
import org.springframework.web.client.RestTemplate;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import java.io.IOException;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class BasicAuthTest {

    private static final String CORRECT_USERNAME = "postgres";
    private static final String CORRECT_PASSWORD = "docker";
    private static final String HEADER_NAME = "Authorization";

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain chain;

    private BasicAuth filter = new BasicAuth();

    @BeforeEach
    public void init_mocks(){
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        chain = mock(FilterChain.class);
    }

    @Test
    void hasBasicAuth_correctCredentials() throws IOException, ServletException {
        when(request.getHeader(HEADER_NAME)).thenReturn(basicAuth(CORRECT_USERNAME, CORRECT_PASSWORD));
        filter.doFilter(request, response, chain);
        verifyZeroInteractions(response);
    }

    @Test
    void hasBasicAuth_emptyRequest() throws IOException, ServletException {
        filter.doFilter(request, response, chain);
        verify(response, atLeastOnce()).setStatus(401);
    }

    @Test
    void hasBasicAuth_incorrectPassword() throws IOException, ServletException {
        when(request.getHeader(HEADER_NAME)).thenReturn(basicAuth(CORRECT_USERNAME, "incorrect"));
        filter.doFilter(request, response, chain);
        verify(response, atLeastOnce()).setStatus(401);
    }

    @Test
    void hasBasicAuth_incorrectUsername() throws IOException, ServletException {
        when(request.getHeader(HEADER_NAME)).thenReturn(basicAuth("incorrect", CORRECT_PASSWORD));
        filter.doFilter(request, response, chain);
        verify(response, atLeastOnce()).setStatus(401);
    }

    @Test
    void hasBasicAuth_invalidBase64Value() throws IOException, ServletException {
        when(request.getHeader(HEADER_NAME)).thenReturn("Basic cG9zdGdyZXM6ZG9ja2VyMg=");
        filter.doFilter(request, response, chain);
        verify(response, atLeastOnce()).setStatus(401);
    }

    @Test
    void hasBasicAuth_wrongAuthType() throws IOException, ServletException {
        when(request.getHeader(HEADER_NAME)).thenReturn("Bearer " + correctCredentials());
        filter.doFilter(request, response, chain);
        verify(response, atLeastOnce()).setStatus(401);
    }

    @Test
    void hasBasicAuth_invalidAuthType() throws IOException, ServletException {
        when(request.getHeader(HEADER_NAME)).thenReturn("Invalid " + correctCredentials());
        filter.doFilter(request, response, chain);
        verify(response, atLeastOnce()).setStatus(401);
    }

    @Test
    void hasBasicAuth_noAuthType() throws IOException, ServletException {
        when(request.getHeader(HEADER_NAME)).thenReturn(correctCredentials());
        filter.doFilter(request, response, chain);
        verify(response, atLeastOnce()).setStatus(401);
    }

    @Test
    void hasBasicAuth_noHeaderValue() throws IOException, ServletException {
        when(request.getHeader(HEADER_NAME)).thenReturn("");
        filter.doFilter(request, response, chain);
        verify(response, atLeastOnce()).setStatus(401);
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
