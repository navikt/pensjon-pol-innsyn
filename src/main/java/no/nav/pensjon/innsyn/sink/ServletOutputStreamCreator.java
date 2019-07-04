package no.nav.pensjon.innsyn.sink;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class ServletOutputStreamCreator implements OutputStreamCreator {

    private final ServletResponse response;

    public ServletOutputStreamCreator(ServletResponse response) {
        this.response = response;
    }

    @Override
    public OutputStream create() throws IOException {
        return response.getOutputStream();
    }
}
