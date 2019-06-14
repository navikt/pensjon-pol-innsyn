package no.nav.pensjon.innsyn.domain;

public class Opptjening {

    private final String type;
    private final String status;
    private final int opptjeningsar;
    private final double pensjonsgivendeInntekt;
    private final double poeng;
    private final double uforegrad;

    public Opptjening(String type,
                      String status,
                      int opptjeningsar,
                      double pensjonsgivendeInntekt,
                      double poeng,
                      double uforegrad) {
        this.type = type;
        this.status = status;
        this.opptjeningsar = opptjeningsar;
        this.pensjonsgivendeInntekt = pensjonsgivendeInntekt;
        this.poeng = poeng;
        this.uforegrad = uforegrad;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public int getOpptjeningsar() {
        return opptjeningsar;
    }

    public double getPensjonsgivendeInntekt() {
        return pensjonsgivendeInntekt;
    }

    public double getPoeng() {
        return poeng;
    }

    public double getUforegrad() {
        return uforegrad;
    }
}
