package no.nav.pensjon.innsyn.popp.domain.support

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_K_DAGPENGER_S")
data class DagpengerStatus(
        @Id
        @Column(name = "K_DAGPENGER_S")
        val id: String,
        @Column(name = "DEKODE")
        val dekode: String
)