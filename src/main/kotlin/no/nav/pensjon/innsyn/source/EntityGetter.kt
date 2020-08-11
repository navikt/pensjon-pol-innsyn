package no.nav.pensjon.innsyn.source

interface EntityGetter<T> {
    val entities: List<T>
}