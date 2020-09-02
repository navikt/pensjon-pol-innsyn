package no.nav.pensjon.innsyn.popp.domain

import no.nav.pensjon.innsyn.common.domain.Domain
import no.nav.pensjon.innsyn.popp.domain.support.KildeType
import no.nav.pensjon.innsyn.popp.domain.support.OmsorgStatus
import no.nav.pensjon.innsyn.popp.domain.support.OmsorgType
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

) : Domain {
    @get:Transient
    val kilde
        get() = kildeType.dekode

    @get:Transient
    val type
        get() = omsorgType.dekode

    @get:Transient
    val status
        get() = omsorgStatus.dekode

    @get:Transient
    override val fields
        get() = setOf(::ar, ::kilde, ::type, ::status)
}