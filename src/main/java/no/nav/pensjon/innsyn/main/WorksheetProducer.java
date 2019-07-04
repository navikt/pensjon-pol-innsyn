package no.nav.pensjon.innsyn.main;

import no.nav.pensjon.innsyn.domain.desc.*;
import no.nav.pensjon.innsyn.domain.map.*;
import no.nav.pensjon.innsyn.domain.source.*;
import no.nav.pensjon.innsyn.entity.EntitySupport;
import no.nav.pensjon.innsyn.poi.ss.DataTransferrer;
import no.nav.pensjon.innsyn.poi.xssf.ExcelWorkbookCreator;
import no.nav.pensjon.innsyn.sink.OutputStreamCreator;
import no.nav.pensjon.innsyn.sql.DbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class WorksheetProducer {

    public static void produceWorksheet(String fnr, OutputStreamCreator outputStreamCreator) throws IOException {
        try (Connection connection = DbConnection.get()) {
            List<EntitySupport<?>> entitySupports = List.of(
                    new EntitySupport<>(
                            new DbBeholdningGetter(fnr, connection),
                            new BeholdningDescriptor(),
                            BeholdningRowFiller::setCellValues),
                    new EntitySupport<>(
                            new DbInntektGetter(fnr, connection),
                            new InntektDescriptor(),
                            InntektRowFiller::setCellValues),
                    new EntitySupport<>(
                            new DbDagpengerGetter(fnr, connection),
                            new DagpengerDescriptor(),
                            DagpengerRowFiller::setCellValues),
                    new EntitySupport<>(
                            new DbFppAfpGetter(fnr, connection),
                            new FppAfpDescriptor(),
                            FppAfpRowFiller::setCellValues),
                    new EntitySupport<>(
                            new DbOmsorgGetter(fnr, connection),
                            new OmsorgDescriptor(),
                            OmsorgRowFiller::setCellValues),
                    new EntitySupport<>(
                            new DbForstegangstjenesteGetter(fnr, connection),
                            new ForstegangstjenesteDescriptor(),
                            ForstegangstjenesteRowFiller::setCellValues),
                    new EntitySupport<>(
                            new DbOpptjeningGetter(fnr, connection),
                            new OpptjeningDescriptor(),
                            OpptjeningRowFiller::setCellValues));

            DataTransferrer.transferEntitiesToWorkbook(
                    entitySupports,
                    new ExcelWorkbookCreator(),
                    outputStreamCreator);
        } catch (SQLException e) {
            throw new IOException("Failed to get DB connection: " + e.getMessage(), e);
        }
    }
}
