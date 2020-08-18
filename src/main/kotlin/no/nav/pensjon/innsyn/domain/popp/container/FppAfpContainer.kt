package no.nav.pensjon.innsyn.domain.popp.container

import no.nav.pensjon.innsyn.domain.popp.FppAfp
import no.nav.pensjon.innsyn.repository.popp.FppAfpRepository
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
        repository
)