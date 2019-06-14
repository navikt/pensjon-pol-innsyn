package no.nav.pensjon.innsyn.domain;

public class Beholdning {

    private final String datoFom;
    private final String datoTom;
    private final double belop;
    private final String beholdningstype;
    private final String status;
    private final double grunnlag;
    private final double grunnlagAvkortet;
    private final double innskudd;
    private final int inntektsar;
    private final double inntektsgrunnlag;
    private final int forstegangstjenesteAr;
    private final String ordinareDagpenger;
    private final int dagpengerAr;
    private final String dagpengerFisker;
    private final int omsorgAr;
    private final double omsorgBelop;
    private final double omsorgInnskudd;
    private final double uforeBelop;
    private final int uforeAr;
    private final String uforegrad;
    private final String uforeYrkesskadegrad;
    private final String uforeAntattInntektYrke;
    private final String uforeYrkesskade;
    private final String uforeUforetrygd;
    private final int uforeUforeAr;
    private final double uforeAntattInntekt;
    private final double reguleringBelop;
    private final String reguleringDato;

    public Beholdning(String datoFom,
                      String datoTom,
                      double belop,
                      String beholdningstype,
                      String status,
                      double grunnlag,
                      double grunnlagAvkortet,
                      double innskudd,
                      int inntektsar,
                      double inntektsgrunnlag,
                      int forstegangstjenesteAr,
                      String ordinareDagpenger,
                      int dagpengerAr,
                      String dagpengerFisker,
                      int omsorgAr,
                      double omsorgBelop,
                      double omsorgInnskudd,
                      double uforeBelop,
                      int uforeAr,
                      String uforegrad,
                      String uforeYrkesskadegrad,
                      String uforeAntattInntektYrke,
                      String uforeYrkesskade,
                      String uforeUforetrygd,
                      int uforeUforeAr,
                      double uforeAntattInntekt,
                      double reguleringBelop,
                      String reguleringDato) {
        this.datoFom = datoFom;
        this.datoTom = datoTom;
        this.belop = belop;
        this.beholdningstype = beholdningstype;
        this.status = status;
        this.grunnlag = grunnlag;
        this.grunnlagAvkortet = grunnlagAvkortet;
        this.innskudd = innskudd;
        this.inntektsar = inntektsar;
        this.inntektsgrunnlag = inntektsgrunnlag;
        this.forstegangstjenesteAr = forstegangstjenesteAr;
        this.ordinareDagpenger = ordinareDagpenger;
        this.dagpengerAr = dagpengerAr;
        this.dagpengerFisker = dagpengerFisker;
        this.omsorgAr = omsorgAr;
        this.omsorgBelop = omsorgBelop;
        this.omsorgInnskudd = omsorgInnskudd;
        this.uforeBelop = uforeBelop;
        this.uforeAr = uforeAr;
        this.uforegrad = uforegrad;
        this.uforeYrkesskadegrad = uforeYrkesskadegrad;
        this.uforeAntattInntektYrke = uforeAntattInntektYrke;
        this.uforeYrkesskade = uforeYrkesskade;
        this.uforeUforetrygd = uforeUforetrygd;
        this.uforeUforeAr = uforeUforeAr;
        this.uforeAntattInntekt = uforeAntattInntekt;
        this.reguleringBelop = reguleringBelop;
        this.reguleringDato = reguleringDato;
    }

    public String getDatoFom() {
        return datoFom;
    }

    public String getDatoTom() {
        return datoTom;
    }

    public double getBelop() {
        return belop;
    }

    public String getBeholdningstype() {
        return beholdningstype;
    }

    public String getStatus() {
        return status;
    }

    public double getGrunnlag() {
        return grunnlag;
    }

    public double getGrunnlagAvkortet() {
        return grunnlagAvkortet;
    }

    public double getInnskudd() {
        return innskudd;
    }

    public int getInntektsar() {
        return inntektsar;
    }

    public double getInntektsgrunnlag() {
        return inntektsgrunnlag;
    }

    public int getForstegangstjenesteAr() {
        return forstegangstjenesteAr;
    }

    public String getOrdinareDagpenger() {
        return ordinareDagpenger;
    }

    public int getDagpengerAr() {
        return dagpengerAr;
    }

    public String getDagpengerFisker() {
        return dagpengerFisker;
    }

    public int getOmsorgAr() {
        return omsorgAr;
    }

    public double getOmsorgBelop() {
        return omsorgBelop;
    }

    public double getOmsorgInnskudd() {
        return omsorgInnskudd;
    }

    public double getUforeBelop() {
        return uforeBelop;
    }

    public int getUforeAr() {
        return uforeAr;
    }

    public String getUforegrad() {
        return uforegrad;
    }

    public String getUforeYrkesskadegrad() {
        return uforeYrkesskadegrad;
    }

    public String getUforeAntattInntektYrke() {
        return uforeAntattInntektYrke;
    }

    public String getUforeYrkesskade() {
        return uforeYrkesskade;
    }

    public String getUforeUforetrygd() {
        return uforeUforetrygd;
    }

    public int getUforeUforeAr() {
        return uforeUforeAr;
    }

    public double getUforeAntattInntekt() {
        return uforeAntattInntekt;
    }

    public double getReguleringBelop() {
        return reguleringBelop;
    }

    public String getReguleringDato() {
        return reguleringDato;
    }
}
