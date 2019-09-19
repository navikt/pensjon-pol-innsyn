package no.nav.pensjon.innsyn.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = {"no.nav.pensjon.innsyn.server.servlet", "no.nav.pensjon.innsyn.server.auth"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("CLIENT_ID = " + System.getenv("CLIENT_ID"));
        SpringApplication.run(Application.class, args);
    }
}
