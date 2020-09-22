package no.nav.pensjon.innsyn.popp.domain.support

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_K_RAPPORT_T")
data class RapportType(
        @Id
        @Column(name = "K_RAPPORT_T")
        val id: String,
        @Column(name = "DEKODE")
        val dekode: String
)