package no.nav.pensjon.innsyn.domain.map

import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.full.valueParameters

class DomainRowFiller<T : Any>(clazz: KClass<T>) {
    private val parameterNames = clazz.primaryConstructor?.valueParameters?.map(KParameter::name) ?: emptyList()
    private val orderedProperties = clazz.declaredMemberProperties.let { l ->
        parameterNames.map { n ->  l.first { it.name == n } }
    }

    fun setCellValues(sink: CellValueSetter, source: T) =
            orderedProperties.forEachIndexed { i, p ->
                when (val v = p.get(source)) {
                    is String -> sink.setCellValue(i, v)
                    is Double -> sink.setCellValue(i, v)
                    is Int -> sink.setCellValue(i, v.toDouble())
                    is Date -> sink.setCellValue(i, v)
                    is Boolean -> sink.setCellValue(i, v)
                    else -> throw RuntimeException()
                }
            }
}