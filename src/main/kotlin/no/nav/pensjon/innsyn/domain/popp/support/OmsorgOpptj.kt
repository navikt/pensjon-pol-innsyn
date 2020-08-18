package no.nav.pensjon.innsyn.domain.popp.support

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_OMSORG_OPPTJ")
data class OmsorgOpptj(
        @Id
        @Column(name = "OMSORG_OPPTJ_ID")
        val id: Int,
        @Column(name = "BELOP")
        val belop: Double,
        @Column(name = "AR")
        val ar: Int,
        @Column(name = "OMS_OPPTJ_INNSKUDD")
        val inskudd: Double
)