package no.nav.pensjon.innsyn.domain.popp.support

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_K_DAGPENGER_T")
data class DagpengerType(
        @Id
        @Column(name = "K_DAGPENGER_T")
        val id: String,
        @Column(name = "DEKODE")
        val dekode: String
)