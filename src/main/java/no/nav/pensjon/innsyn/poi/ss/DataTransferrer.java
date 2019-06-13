package no.nav.pensjon.innsyn.poi.ss;

import no.nav.pensjon.innsyn.entity.EntitySupport;
import no.nav.pensjon.innsyn.sink.OutputStreamCreator;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataTransferrer {

    public static void transferEntitiesToWorkbook(List<EntitySupport<?>> entitySupports,
                                                  WorkbookCreator workbookCreator,
                                                  OutputStreamCreator outputStreamCreator) throws IOException {
        List<SheetPopulator> populators = entitySupports
                .stream()
                .map((Function<EntitySupport<?>, SheetFiller>) SheetFiller::new)
                .collect(Collectors.toList());

        WorkbookWriter.createFile(workbookCreator, populators, outputStreamCreator);
    }
}
