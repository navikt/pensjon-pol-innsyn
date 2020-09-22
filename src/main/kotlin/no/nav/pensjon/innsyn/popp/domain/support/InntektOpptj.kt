package no.nav.pensjon.innsyn.popp.domain.support

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_INNTEKT_OPPTJ")
data class InntektOpptj(
        @Id
        @Column(name = "INNTEKT_OPPTJ_ID")
        val id: Int,
//        @ManyToOne
//        @JoinColumn(name = "INNTEKT_ID")
//        val inntekt: Inntekt,
        @Column(name = "BELOP")
        val belop: Double,
        @Column(name = "AR")
        val ar: Int
)