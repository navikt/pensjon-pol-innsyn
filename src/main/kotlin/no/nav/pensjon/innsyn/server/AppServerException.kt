package no.nav.pensjon.innsyn.server

class AppServerException(message: String, cause: Throwable) : RuntimeException("$message: ${cause.message}", cause)