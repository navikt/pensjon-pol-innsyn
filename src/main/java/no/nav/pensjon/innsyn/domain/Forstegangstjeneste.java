package no.nav.pensjon.innsyn.domain;

public class Forstegangstjeneste {

    private final String tjenestestart;
    private final String dimittert;
    private final String rapporttype;
    private final String status;
    private final String kilde;

    public Forstegangstjeneste(String tjenestestart, String dimittert, String rapporttype, String status, String kilde) {
        this.tjenestestart = tjenestestart;
        this.dimittert = dimittert;
        this.rapporttype = rapporttype;
        this.status = status;
        this.kilde = kilde;
    }

    public String getTjenestestart() {
        return tjenestestart;
    }

    public String getDimittert() {
        return dimittert;
    }

    public String getRapporttype() {
        return rapporttype;
    }

    public String getStatus() {
        return status;
    }

    public String getKilde() {
        return kilde;
    }
}
