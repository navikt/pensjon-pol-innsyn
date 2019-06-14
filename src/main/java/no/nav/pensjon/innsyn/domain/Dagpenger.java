package no.nav.pensjon.innsyn.domain;

public class Dagpenger {

    private final double ferietillegg;
    private final double barnetillegg;
    private final double dagpenger;
    private final double uavkortetGrunnlag;
    private final int arDagpengerUtbetalt;
    private final String kilde;
    private final String status;
    private final String type;
    private final String rapporttype;

    public Dagpenger(double ferietillegg,
                     double barnetillegg,
                     double dagpenger,
                     double uavkortetGrunnlag,
                     int arDagpengerUtbetalt,
                     String kilde,
                     String status,
                     String type,
                     String rapporttype) {
        this.ferietillegg = ferietillegg;
        this.barnetillegg = barnetillegg;
        this.dagpenger = dagpenger;
        this.uavkortetGrunnlag = uavkortetGrunnlag;
        this.arDagpengerUtbetalt = arDagpengerUtbetalt;
        this.kilde = kilde;
        this.status = status;
        this.type = type;
        this.rapporttype = rapporttype;
    }

    public double getFerietillegg() {
        return ferietillegg;
    }

    public double getBarnetillegg() {
        return barnetillegg;
    }

    public double getDagpenger() {
        return dagpenger;
    }

    public double getUavkortetGrunnlag() {
        return uavkortetGrunnlag;
    }

    public int getArDagpengerUtbetalt() {
        return arDagpengerUtbetalt;
    }

    public String getKilde() {
        return kilde;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getRapporttype() {
        return rapporttype;
    }
}
