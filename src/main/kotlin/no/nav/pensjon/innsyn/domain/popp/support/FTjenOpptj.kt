package no.nav.pensjon.innsyn.domain.popp.support

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_F_TJEN_OPPTJ")
data class FTjenOpptj(
        @Id
        @Column(name = "F_TJEN_OPPTJ_ID")
        val id: Int,
        @Column(name = "AR")
        val ar: Int
)