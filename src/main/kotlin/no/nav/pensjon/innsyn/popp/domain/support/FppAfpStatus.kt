package no.nav.pensjon.innsyn.popp.domain.support

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_K_FPP_AFP_S")
data class FppAfpStatus(
        @Id
        @Column(name = "K_FPP_AFP_S")
        val id: String,
        @Column(name = "DEKODE")
        val dekode: String
)