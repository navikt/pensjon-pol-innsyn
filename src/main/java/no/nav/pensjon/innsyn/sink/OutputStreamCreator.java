package no.nav.pensjon.innsyn.sink;

import java.io.IOException;
import java.io.OutputStream;

public interface OutputStreamCreator {

    OutputStream create() throws IOException;
}
