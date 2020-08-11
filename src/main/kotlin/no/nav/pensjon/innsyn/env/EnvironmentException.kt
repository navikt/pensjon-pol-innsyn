package no.nav.pensjon.innsyn.env

class EnvironmentException(message: String, environmentVariableName: String)
    : RuntimeException("$message: $environmentVariableName")