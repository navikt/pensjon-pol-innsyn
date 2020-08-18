package no.nav.pensjon.innsyn.domain.popp

import no.nav.pensjon.innsyn.domain.Domain
import no.nav.pensjon.innsyn.domain.popp.support.KildeType
import no.nav.pensjon.innsyn.domain.popp.support.OmsorgStatus
import no.nav.pensjon.innsyn.domain.popp.support.OmsorgType
import javax.persistence.*


@Entity
@Table(name = "T_OMSORG")
data class Omsorg(
        @Id
        @Column(name = "PERSON_ID")
        val personId: Int,
        @Column(name = "AR")
        val ar: Int,
        @ManyToOne
        @JoinColumn(name = "K_KILDE_T")
        val kildeType: KildeType,
        @ManyToOne
        @JoinColumn(name = "K_OMSORG_T")
        val omsorgType: OmsorgType,
        @ManyToOne
        @JoinColumn(name = "K_OMSORG_S")
        val omsorgStatus: OmsorgStatus

        ): Domain {
    @Transient
    val kilde = kildeType.dekode
    @Transient
    val type = omsorgType.dekode
    @Transient
    val status = omsorgStatus.dekode
    @Transient
    override val fields = setOf(::kilde, ::type, ::status, ::ar)
}