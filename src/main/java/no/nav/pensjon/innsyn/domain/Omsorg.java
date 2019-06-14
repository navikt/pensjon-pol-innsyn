package no.nav.pensjon.innsyn.domain;

public class Omsorg {

    private final int ar;
    private final String kilde;
    private final String type;
    private final String status;

    public Omsorg(int ar, String kilde, String type, String status) {
        this.ar = ar;
        this.kilde = kilde;
        this.type = type;
        this.status = status;
    }

    public int getAr() {
        return ar;
    }

    public String getKilde() {
        return kilde;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }
}
