package no.nav.pensjon.innsyn.controller

import io.prometheus.client.Counter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(EmptyResultDataAccessException::class)
    @ResponseStatus(NOT_FOUND)
    fun emptyResultFromRepository(e: EmptyResultDataAccessException) {/*No body*/}

    @ExceptionHandler(DataIntegrityViolationException::class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    fun sqlException(e: DataIntegrityViolationException): String {
        LOG.error("Error parsing SQL data.", e)
        errorCounter.labels("SQL").inc()
        return "Database error."
    }

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(ExceptionHandler::class.java)
        val errorCounter: Counter = Counter.build()
                .help("Interne feil kastet av POL-innsyn.")
                .namespace("pol-innsyn")
                .name("internal_server_errors_total")
                .labelNames("cause")
                .register()
    }
}