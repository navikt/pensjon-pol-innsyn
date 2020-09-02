package no.nav.pensjon.innsyn.popp.domain.support

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_K_OPPTJN_STATUS")
data class OpptjeningStatus(
        @Id
        @Column(name = "K_OPPTJN_STATUS")
        val id: String,
        @Column(name = "DEKODE")
        val dekode: String
)