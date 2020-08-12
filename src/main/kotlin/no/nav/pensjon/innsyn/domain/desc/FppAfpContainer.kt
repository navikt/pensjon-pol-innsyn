package no.nav.pensjon.innsyn.domain.desc

import no.nav.pensjon.innsyn.domain.FppAfp
import no.nav.pensjon.innsyn.service.map.DomainRowFiller
import no.nav.pensjon.innsyn.domain.repository.FppAfpRepository
import no.nav.pensjon.innsyn.entity.PoppContainer
import org.springframework.stereotype.Component

@Component
class FppAfpContainer(repository: FppAfpRepository) : PoppContainer<FppAfp>("FPP AFP",
        arrayOf(
                "Status",
                "Framtidige pensjonspoeng AFP",
                "Gjelder f.o.m.",
                "Gjelder t.o.m.",
                "AFP pensjonsgrad",
                "AFP type"
        ),
        repository,
        DomainRowFiller(FppAfp::class)::setCellValues
)