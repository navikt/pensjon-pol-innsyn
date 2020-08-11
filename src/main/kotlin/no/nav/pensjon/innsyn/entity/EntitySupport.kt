package no.nav.pensjon.innsyn.entity

import no.nav.pensjon.innsyn.domain.map.CellValueSetter
import no.nav.pensjon.innsyn.source.EntityGetter

class EntitySupport<T>(val entityGetter: EntityGetter<T>,
                       val entityDescriptor: EntityDescriptor<T>,
                       val rowFiller: (CellValueSetter, T) -> Unit)