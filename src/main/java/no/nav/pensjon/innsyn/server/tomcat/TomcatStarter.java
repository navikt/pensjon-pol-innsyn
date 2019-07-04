package no.nav.pensjon.innsyn.server.tomcat;

import no.nav.pensjon.innsyn.server.AppServerException;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

/**
 * Adapted from
 * https://devcenter.heroku.com/articles/create-a-java-web-application-using-embedded-tomcat
 */
public class TomcatStarter {

    private static final String WEBAPP_RELATIVE_PATH = "src/main/webapp/";
    private static final String WEBAPP_MOUNT = "/WEB-INF/classes";
    private static final String RELATIVE_RESOURCE_BASE = "target/classes";
    private static final int DEFAULT_WEB_PORT = 8080;

    public static void startServer() {
        var server = new Tomcat();
        server.setPort(getWebPort());
        prepareContext(server);
        start(server);
        server.getServer().await();
    }

    private static int getWebPort() {
        String webPort = System.getenv("TOMCAT_PORT");
        return webPort == null || webPort.isEmpty() ? DEFAULT_WEB_PORT : Integer.valueOf(webPort);
    }

    private static void prepareContext(Tomcat server) {
        var context = (StandardContext) server.addWebapp("", absolutePath(WEBAPP_RELATIVE_PATH));
        var webResourceRoot = new StandardRoot(context);
        String resourceBase = absolutePath(RELATIVE_RESOURCE_BASE);
        webResourceRoot.addPreResources(new DirResourceSet(webResourceRoot, WEBAPP_MOUNT, resourceBase, "/"));
        context.setResources(webResourceRoot);
    }

    private static void start(Tomcat server) {
        try {
            server.start();
        } catch (LifecycleException e) {
            throw new AppServerException("Failed to start Tomcat", e);
        }
    }

    private static String absolutePath(String relativePath) {
        return new File(relativePath).getAbsolutePath();
    }
}
