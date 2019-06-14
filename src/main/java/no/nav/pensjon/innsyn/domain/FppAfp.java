package no.nav.pensjon.innsyn.domain;

/**
 * FPP = Framtidige pensjonspoeng
 * AFP = Avtalefestet pensjon
 */
public class FppAfp {

    private final String status;
    private final double fppAfp;
    private final String gjelderFom;
    private final String gjelderTom;
    private final double afpPensjonsgrad;
    private final String afpType;

    public FppAfp(String status,
                  double fppAfp,
                  String gjelderFom,
                  String gjelderTom,
                  double afpPensjonsgrad,
                  String afpType) {
        this.status = status;
        this.fppAfp = fppAfp;
        this.gjelderFom = gjelderFom;
        this.gjelderTom = gjelderTom;
        this.afpPensjonsgrad = afpPensjonsgrad;
        this.afpType = afpType;
    }

    public String getStatus() {
        return status;
    }

    public double getFppAfp() {
        return fppAfp;
    }

    public String getGjelderFom() {
        return gjelderFom;
    }

    public String getGjelderTom() {
        return gjelderTom;
    }

    public double getAfpPensjonsgrad() {
        return afpPensjonsgrad;
    }

    public String getAfpType() {
        return afpType;
    }
}
