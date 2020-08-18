package no.nav.pensjon.innsyn.domain.popp.support

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_DAGPENGER_OPPTJ")
data class DagpengerOpptj(
        @Id
        @Column(name = "DAGPENGER_OPPTJ_ID")
        val id: Int,
        @Column(name = "BELOP_ORDINAR")
        val belopOrdinar: Double,
        @Column(name = "AR")
        val ar: Int,
        @Column(name = "BELOP_FISKERE")
        val belopFiskere: Double
)