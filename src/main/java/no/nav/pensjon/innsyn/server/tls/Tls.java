package no.nav.pensjon.innsyn.server.tls;

import org.apache.catalina.connector.Connector;

/**
 * Transport Layer Security (TLS, formerly SSL).
 * To generate self-signed test certificate:
 * $ keytool -genkeypair -alias innsyntest -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore selfsigned.p12 -validity 3650
 */
public class Tls {

    private static final int DEFAULT_PORT = 9000;

    public static Connector getConnector() {
        var connector = new Connector();
        connector.setPort(getTlsPort());
        connector.setSecure(true);
        connector.setScheme("https");
        connector.setAttribute("keyAlias", "innsyntest");
        connector.setAttribute("keystorePass", "changeit");
        connector.setAttribute("keystoreType", "PKCS12");
        connector.setAttribute("keystoreFile", "../src/main/resources/keystore/selfsigned.p12");
        connector.setAttribute("clientAuth", "false");
        connector.setAttribute("protocol", "HTTP/1.1");
        connector.setAttribute("sslProtocol", "TLS");
        connector.setAttribute("maxThreads", "200");
        connector.setAttribute("protocol", "org.apache.coyote.http11.Http11AprProtocol");
        connector.setAttribute("SSLEnabled", true);
        return connector;
    }

    private static int getTlsPort() {
        String port = System.getenv("TOMCAT_TLS_PORT");
        return port == null || port.isEmpty() ? DEFAULT_PORT : Integer.valueOf(port);
    }
}
