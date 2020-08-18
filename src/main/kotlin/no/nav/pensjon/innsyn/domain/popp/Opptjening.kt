package no.nav.pensjon.innsyn.domain.popp

import no.nav.pensjon.innsyn.domain.Domain
import no.nav.pensjon.innsyn.domain.popp.support.OpptjeningStatus
import no.nav.pensjon.innsyn.domain.popp.support.OpptjeningType
import javax.persistence.*

@Entity
@Table(name = "T_OPPTJN")
@SecondaryTables(
        SecondaryTable(name = "T_K_OPPTJN_T", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_OPPTJN_T")]),
        SecondaryTable(name = "T_K_OPPTJN_STATUS", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_OPPTJN_STATUS")])
)
data class Opptjening(
        @Id
        @Column(name = "PERSON_ID_OPPTJN")
        private val personId: Int,
        @Column(name = "OPPTJN_AR")
        val opptjeningsar: Int,
        @Column(name = "PGI_ANVENDT")
        val pensjonsgivendeInntekt: Double,
        @Column(name = "POENG")
        val poeng: Double,
        @Column(name = "MAX_UFOREGRAD")
        val uforegrad: Double,
        @ManyToOne
        @JoinColumn(name = "K_OPPTJN_T")
        private val opptjeningType: OpptjeningType,
        @ManyToOne
        @JoinColumn(name = "K_OPPTJN_STATUS")
        private val opptjeningStatus: OpptjeningStatus
): Domain {
    @field:Transient
    val type = opptjeningType.dekode
    @field:Transient
    val status = opptjeningStatus.dekode
    @field:Transient
    override val fields = setOf(::type, ::status, ::opptjeningsar, ::pensjonsgivendeInntekt, ::poeng, ::uforegrad)
}