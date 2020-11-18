package no.nav.pensjon.innsyn.popp.domain

import no.nav.pensjon.innsyn.common.domain.Domain
import no.nav.pensjon.innsyn.popp.domain.support.FppAfpStatus
import java.time.LocalDate
import javax.persistence.*

/**
 * FPP = Framtidige pensjonspoeng
 * AFP = Avtalefestet pensjon
 */
@Entity
@Table(name = "T_FPP_AFP")
@SecondaryTable(name = "T_K_FPP_AFP_S", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_FPP_AFP_S")])
data class FppAfp(
        @Id
        @Column(name = "PERSON_ID")
        private val personId: Int,
        @ManyToOne
        @JoinColumn(name = "K_FPP_AFP_S")
        private val fppAfpStatus: FppAfpStatus,
        @Column(name = "AFP_FPP")
        val fppAfp: Double,
        @Column(name = "VIRK_FOM")
        val gjelderFom: LocalDate,
        @Column(name = "VIRK_TOM")
        val gjelderTom: LocalDate?,
        @Column(name = "AFP_PENSJONSGRAD")
        val afpPensjonsgrad: Double,
        @Column(name = "AFP_TYPE")
        val afpType: String
) : Domain {
    @get:Transient
    val status
        get() = fppAfpStatus.dekode

    @get:Transient
    override val fields
        get() = setOf(::status, ::fppAfp, ::gjelderFom, ::gjelderTom, ::afpPensjonsgrad, ::afpType)
}