package no.nav.pensjon.innsyn.domain

import kotlin.reflect.KProperty

interface Domain {
    val fields: Set<KProperty<*>>
}