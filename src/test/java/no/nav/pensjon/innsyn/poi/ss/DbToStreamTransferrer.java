package no.nav.pensjon.innsyn.poi.ss;

import no.nav.pensjon.innsyn.sink.OutputStreamCreator;

import java.io.IOException;
import java.sql.Connection;

@FunctionalInterface
interface DbToStreamTransferrer {
    void transfer(Connection in, OutputStreamCreator out) throws IOException;
}
