package no.nav.pensjon.innsyn.entity

abstract class EntityDescriptor<T>(val entityName: String,
                                val propertyNames: Array<String>)