package no.nav.pensjon.innsyn.domain;

public class Inntekt {

    private final String type;
    private final String status;
    private final int inntektsar;
    private final double belop;
    private final String rapportdato;
    private final String kilde;

    public Inntekt(String type, String status, int inntektsar, double belop, String rapportdato, String kilde) {
        this.type = type;
        this.status = status;
        this.inntektsar = inntektsar;
        this.belop = belop;
        this.rapportdato = rapportdato;
        this.kilde = kilde;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public int getInntektsar() {
        return inntektsar;
    }

    public double getBelop() {
        return belop;
    }

    public String getRapportdato() {
        return rapportdato;
    }

    public String getKilde() {
        return kilde;
    }
}
