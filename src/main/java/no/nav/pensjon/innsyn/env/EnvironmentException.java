package no.nav.pensjon.innsyn.env;

public class EnvironmentException extends RuntimeException {

    public EnvironmentException(String message, String environmentVariableName) {
        super(message + ": " + environmentVariableName);
    }
}
