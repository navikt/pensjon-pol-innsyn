package no.nav.pensjon.innsyn.popp.domain.support

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_K_F_TJEN_TOT_S")
data class FTjenStatus(
        @Id
        @Column(name = "K_F_TJEN_TOT_S")
        val id: String,
        @Column(name = "DEKODE")
        val dekode: String
)