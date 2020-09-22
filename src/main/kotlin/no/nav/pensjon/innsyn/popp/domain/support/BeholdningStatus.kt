package no.nav.pensjon.innsyn.popp.domain.support

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_K_BEHOLDNING_S")
data class BeholdningStatus(
        @Id
        @Column(name = "K_BEHOLDNING_S")
        val id: String,
        @Column(name = "DEKODE")
        val dekode: String
)