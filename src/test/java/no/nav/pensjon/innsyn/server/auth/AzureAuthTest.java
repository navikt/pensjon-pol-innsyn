package no.nav.pensjon.innsyn.server.auth;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.ExecutionException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import no.nav.pensjon.aad.auth.Client;

@RunWith(MockitoJUnitRunner.class)
class AzureAuthTest {

    private static final String CORRECT_USERNAME = System.getenv("USERNAME");
    private static final String CORRECT_PASSWORD = new String(Base64.getDecoder().decode(System.getenv("PASSWORD")));
    private static final String HEADER_NAME = "Authorization";
    private static Client aad = new Client();

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain chain;

    private AzureAuth filter = new AzureAuth();

    @BeforeEach
    public void init_mocks() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        chain = mock(FilterChain.class);
    }

    @Test
    void hasBasicAuth_correctCredentials() throws IOException, ServletException, ExecutionException {
        when(request.getHeader(HEADER_NAME)).thenReturn(bearerToken());
        filter.doFilter(request, response, chain);
        verifyZeroInteractions(response);
    }

    @Test
    void hasBasicAuth_emptyRequest() throws IOException, ServletException {
        filter.doFilter(request, response, chain);
        verify(response, atLeastOnce()).setStatus(401);
    }

    @Test
    void hasBasicAuth_invalidToken() throws IOException, ServletException {
        when(request.getHeader(HEADER_NAME)).thenReturn("Bearer cG9zdGdyZXM6ZG9ja2VyMg=");
        filter.doFilter(request, response, chain);
        verify(response, atLeastOnce()).setStatus(401);
    }

    @Test
    void hasBasicAuth_wrongAuthType() throws IOException, ServletException, ExecutionException {
        when(request.getHeader(HEADER_NAME)).thenReturn(bearerToken().replace("Bearer ", "Basic "));
        filter.doFilter(request, response, chain);
        verify(response, atLeastOnce()).setStatus(401);
    }

    @Test
    void hasBasicAuth_invalidAuthType() throws IOException, ServletException, ExecutionException {
        when(request.getHeader(HEADER_NAME)).thenReturn(bearerToken().replace("Bearer ", "Invalid "));
        filter.doFilter(request, response, chain);
        verify(response, atLeastOnce()).setStatus(401);
    }

    @Test
    void hasBasicAuth_noAuthType() throws IOException, ServletException, ExecutionException {
        when(request.getHeader(HEADER_NAME)).thenReturn(bearerToken().replace("Bearer ", ""));
        filter.doFilter(request, response, chain);
        verify(response, atLeastOnce()).setStatus(401);
    }

    @Test
    void hasBasicAuth_noHeaderValue() throws IOException, ServletException {
        when(request.getHeader(HEADER_NAME)).thenReturn("");
        filter.doFilter(request, response, chain);
        verify(response, atLeastOnce()).setStatus(401);
    }

    private static String bearerToken() throws ExecutionException {
        return aad.getAuthorizationHeader(CORRECT_USERNAME, CORRECT_PASSWORD);
    }
}
