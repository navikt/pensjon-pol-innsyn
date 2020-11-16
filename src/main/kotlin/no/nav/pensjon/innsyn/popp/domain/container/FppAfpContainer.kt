package no.nav.pensjon.innsyn.popp.domain.container

import no.nav.pensjon.innsyn.popp.domain.FppAfp
import no.nav.pensjon.innsyn.popp.repository.FppAfpRepository
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