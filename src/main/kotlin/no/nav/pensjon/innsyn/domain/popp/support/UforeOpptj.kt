package no.nav.pensjon.innsyn.domain.popp.support

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_UFORE_OPPTJ")
data class UforeOpptj(
        @Id
        @Column(name = "UFORE_OPPTJ_ID")
        val id: Int,
        @Column(name = "BELOP")
        val belop: Double,
        @Column(name = "AR")
        val ar: Int,
        @Column(name = "UFG")
        val ufg: Double,
        @Column(name = "ANTATT_INNTEKT")
        val antattInntekt: Double,
        @Column(name = "YUG")
        val yug: Double,
        @Column(name = "ANTATT_INNTEKT_YRKE")
        val antattInntektYrke: Double,
        @Column(name = "YRKESSKADE", columnDefinition = "INT(1)")
        val yrkesskade: Boolean,
        @Column(name = "UFORETRYGD", columnDefinition = "INT(1)")
        val uforetrygd: Boolean,
        @Column(name = "UFOREAR", columnDefinition = "INT(1)")
        val uforear: Boolean
)