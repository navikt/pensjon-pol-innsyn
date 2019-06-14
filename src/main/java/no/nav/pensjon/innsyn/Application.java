package no.nav.pensjon.innsyn;

import no.nav.pensjon.innsyn.domain.desc.*;
import no.nav.pensjon.innsyn.domain.map.*;
import no.nav.pensjon.innsyn.domain.source.*;
import no.nav.pensjon.innsyn.entity.EntitySupport;
import no.nav.pensjon.innsyn.poi.ss.DataTransferrer;
import no.nav.pensjon.innsyn.poi.xssf.ExcelWorkbookCreator;
import no.nav.pensjon.innsyn.sink.FileOutputStreamCreator;

import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String fnr = args.length < 1 ? "01029312345" : args[0];

        try {
            List<EntitySupport<?>> entitySupports = List.of(
                    new EntitySupport<>(
                            new DbBeholdningGetter(fnr),
                            new BeholdningDescriptor(),
                            BeholdningRowFiller::setCellValues),
                    new EntitySupport<>(
                            new DbInntektGetter(fnr),
                            new InntektDescriptor(),
                            InntektRowFiller::setCellValues),
                    new EntitySupport<>(
                            new HardcodedDagpenger(),
                            new DagpengerDescriptor(),
                            DagpengerRowFiller::setCellValues),
                    new EntitySupport<>(
                            new HardcodedFppAfp(),
                            new FppAfpDescriptor(),
                            FppAfpRowFiller::setCellValues),
                    new EntitySupport<>(
                            new HardcodedOmsorg(),
                            new OmsorgDescriptor(),
                            OmsorgRowFiller::setCellValues),
                    new EntitySupport<>(
                            new HardcodedForstegangstjeneste(),
                            new ForstegangstjenesteDescriptor(),
                            ForstegangstjenesteRowFiller::setCellValues),
                    new EntitySupport<>(
                            new HardcodedOpptjening(),
                            new OpptjeningDescriptor(),
                            OpptjeningRowFiller::setCellValues));

            DataTransferrer.transferEntitiesToWorkbook(
                    entitySupports,
                    new ExcelWorkbookCreator(),
                    new FileOutputStreamCreator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
