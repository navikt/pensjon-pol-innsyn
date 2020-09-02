package no.nav.pensjon.innsyn.popp.domain.support

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_LONN_VEKST_REG")
data class LonnsvekstReg(
        @Id
        @Column(name = "LONNSVEKST_REG_ID")
        val id: Int,
        @Column(name = "REGULERINGSBELOP")
        val belop: Double,
        @Column(name = "REGULERING_DATO")
        val dato: LocalDate
)