package no.nav.pensjon.innsyn.sink;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOutputStreamCreator implements OutputStreamCreator {

    private static final String FILE_NAME = "poi-generated-file.xlsx";

    @Override
    public OutputStream create() {
        try {
            return new FileOutputStream(FILE_NAME);
        } catch (FileNotFoundException e) {
            throw new SinkException(String.format("Failed to create file output stream; file '%s' not found; %s",
                    FILE_NAME, e.getMessage()), e);
        }
    }
}
