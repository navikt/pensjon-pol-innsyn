package no.nav.pensjon.innsyn.main

import no.nav.pensjon.innsyn.domain.*
import no.nav.pensjon.innsyn.domain.desc.*
import no.nav.pensjon.innsyn.domain.map.DomainRowFiller
import no.nav.pensjon.innsyn.domain.source.*
import no.nav.pensjon.innsyn.entity.EntitySupport
import no.nav.pensjon.innsyn.poi.ss.SheetFiller
import no.nav.pensjon.innsyn.sql.DbConnection
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.IOException
import java.sql.SQLException

object WorksheetProducer {
    fun producePOPPWorksheet(fnr: String) = try {
        DbConnection.get().use { connection ->
            XSSFWorkbook().use {
                it.populate(
                        EntitySupport(
                                DbBeholdningGetter(fnr, connection),
                                BeholdningDescriptor,
                                DomainRowFiller(Beholdning::class)::setCellValues),
                        EntitySupport(
                                DbInntektGetter(fnr, connection),
                                InntektDescriptor,
                                DomainRowFiller(Inntekt::class)::setCellValues),
                        EntitySupport(
                                DbDagpengerGetter(fnr, connection),
                                DagpengerDescriptor,
                                DomainRowFiller(Dagpenger::class)::setCellValues),
                        EntitySupport(
                                DbFppAfpGetter(fnr, connection),
                                FppAfpDescriptor,
                                DomainRowFiller(FppAfp::class)::setCellValues),
                        EntitySupport(
                                DbOmsorgGetter(fnr, connection),
                                OmsorgDescriptor,
                                DomainRowFiller(Omsorg::class)::setCellValues),
                        EntitySupport(
                                DbForstegangstjenesteGetter(fnr, connection),
                                ForstegangstjenesteDescriptor,
                                DomainRowFiller(Forstegangstjeneste::class)::setCellValues),
                        EntitySupport(
                                DbOpptjeningGetter(fnr, connection),
                                OpptjeningDescriptor,
                                DomainRowFiller(Opptjening::class)::setCellValues)
                )
                it
            }
        }
    } catch (e: SQLException) {
        throw IOException("Failed to get DB connection: ${e.message}", e)
    }

    private fun XSSFWorkbook.populate(vararg entitySupports: EntitySupport<*>) =
            entitySupports.map { SheetFiller(it) }
                    .forEach { it.populateSheet(this) }
}