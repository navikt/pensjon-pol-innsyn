package no.nav.pensjon.innsyn.server;

public class AppServerException extends RuntimeException {

    public AppServerException(String message, Throwable cause) {
        super(message + ": " + cause.getMessage(), cause);
    }
}
