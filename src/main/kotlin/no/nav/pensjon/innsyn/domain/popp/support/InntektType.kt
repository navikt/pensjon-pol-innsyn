package no.nav.pensjon.innsyn.domain.popp.support

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_K_INNTEKT_T")
data class InntektType(
        @Id
        @Column(name = "K_INNTEKT_T")
        val id: String,
        @Column(name = "DEKODE")
        val dekode: String
)