package no.nav.pensjon.innsyn;

import no.nav.pensjon.innsyn.entity.EntitySupport;
import no.nav.pensjon.innsyn.poi.ss.DataTransferrer;
import no.nav.pensjon.innsyn.poi.xssf.ExcelWorkbookCreator;
import no.nav.pensjon.innsyn.sink.FileOutputStreamCreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            List<EntitySupport<?>> entitySupports = new ArrayList<>();

            DataTransferrer.transferEntitiesToWorkbook(
                    entitySupports,
                    new ExcelWorkbookCreator(),
                    new FileOutputStreamCreator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
