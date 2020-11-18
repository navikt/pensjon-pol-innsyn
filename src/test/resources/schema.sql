-- create schema authorization popp;
-- ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY.MM.DD';

CREATE TABLE T_BEHOLDNING(
    beholdning_id      INTEGER PRIMARY KEY,
    belop              NUMERIC,
    dato_fom           date,
    dato_tom           date,
    k_beholdning_t     VARCHAR(20),
    k_beholdning_s     VARCHAR(20),
    k_restp_beh_arsak  VARCHAR(20),
    person_id          INTEGER,
    beh_grlag          NUMERIC,
    beh_grlag_avkortet NUMERIC,
    beh_innskudd       NUMERIC,
    f_tjen_opptj_id    INTEGER,
    ufore_opptj_id     INTEGER,
    omsorg_opptj_id    INTEGER,
    inntekt_opptj_id   INTEGER,
    dagpenger_opptj_id INTEGER,
    lonnsvekst_reg_id  INTEGER
);

CREATE TABLE T_DAGPENGER(
    dagpenger_id       INTEGER PRIMARY KEY,
    ferietillegg       NUMERIC,
    barnetillegg       NUMERIC,
    dagpenger          NUMERIC,
    uavkortet_dp_grlag NUMERIC,
    person_id          INTEGER,
    ar                 INTEGER,
    k_dagpenger_t      VARCHAR(20),
    k_dagpenger_s      VARCHAR(20),
    k_kilde_t          VARCHAR(20),
    k_rapport_t        VARCHAR(20)
);

CREATE TABLE T_DAGPENGER_OPPTJ(
    dagpenger_opptj_id INTEGER PRIMARY KEY,
    belop_ordinar      NUMERIC,
    ar                 INTEGER,
    belop_fiskere      NUMERIC
);

CREATE TABLE T_F_TJEN_OPPTJ(
    f_tjen_opptj_id INTEGER PRIMARY KEY,
    ar              INTEGER
);

CREATE TABLE T_F_TJEN_TOT(
    f_tjen_tot_id      INTEGER PRIMARY KEY,
    person_id          INTEGER,
    dato_tjenestestart date,
    dato_dimittering   date,
    k_kilde_t          VARCHAR(20),
    k_rapport_t        VARCHAR(20),
    k_f_tjen_tot_s     VARCHAR(20)
);

CREATE TABLE T_FPP_AFP(
    fpp_afp_id       INTEGER PRIMARY KEY,
    person_id        INTEGER,
    virk_fom         date,
    virk_tom         date,
    afp_fpp          NUMERIC,
    afp_pensjonsgrad NUMERIC,
    afp_type         VARCHAR(20),
    k_fpp_afp_s      VARCHAR(20)
);

CREATE TABLE T_INNTEKT(
    inntekt_id       INTEGER PRIMARY KEY,
    belop            NUMERIC,
    pi_rappdato      date,
    person_id        INTEGER,
    inntekt_ar       INTEGER,
    k_inntekt_t      VARCHAR(20),
    k_inntekt_status VARCHAR(20),
    k_kilde_t        VARCHAR(20)
);

CREATE TABLE T_INNTEKT_OPPTJ(
    inntekt_id       INTEGER,
    inntekt_opptj_id INTEGER PRIMARY KEY,
    belop            NUMERIC,
    ar               INTEGER
);

CREATE TABLE T_K_BEHOLDNING_S(
    k_beholdning_s VARCHAR(20) PRIMARY KEY,
    dekode         VARCHAR(20)
);

CREATE TABLE T_K_BEHOLDNING_T(
    k_beholdning_t VARCHAR(20) PRIMARY KEY,
    dekode         VARCHAR(20)
);

CREATE TABLE T_K_DAGPENGER_S(
    k_dagpenger_s VARCHAR(20) PRIMARY KEY,
    dekode        VARCHAR(20)
);

CREATE TABLE T_K_DAGPENGER_T(
    k_dagpenger_t VARCHAR(20) PRIMARY KEY,
    dekode        VARCHAR(20)
);

CREATE TABLE T_K_F_TJEN_TOT_S(
    k_f_tjen_tot_s VARCHAR(20) PRIMARY KEY,
    dekode         VARCHAR(20)
);

CREATE TABLE T_K_FPP_AFP_S(
    k_fpp_afp_s VARCHAR(20) PRIMARY KEY,
    status      VARCHAR(20),
    dekode      VARCHAR(20)
);

CREATE TABLE T_K_INNTEKT_STATUS(
    k_inntekt_status VARCHAR(20) PRIMARY KEY,
    dekode           VARCHAR(20)
);

CREATE TABLE T_K_INNTEKT_T(
    k_inntekt_t VARCHAR(20) PRIMARY KEY,
    dekode      VARCHAR(20)
);

CREATE TABLE T_K_KILDE_T(
    k_kilde_t VARCHAR(20) PRIMARY KEY,
    dekode    VARCHAR(20)
);

CREATE TABLE T_K_OMSORG_S(
    k_omsorg_s VARCHAR(20) PRIMARY KEY,
    dekode     VARCHAR(20)
);

CREATE TABLE T_K_OMSORG_T(
    k_omsorg_t VARCHAR(20) PRIMARY KEY,
    dekode     VARCHAR(20)
);

CREATE TABLE T_K_OPPTJN_STATUS(
    k_opptjn_status VARCHAR(20) PRIMARY KEY,
    dekode          VARCHAR(20)
);

CREATE TABLE T_K_OPPTJN_T(
    k_opptjn_t VARCHAR(20) PRIMARY KEY,
    dekode     VARCHAR(20)
);

CREATE TABLE T_K_RAPPORT_T(
    k_rapport_t VARCHAR(20) PRIMARY KEY,
    dekode      VARCHAR(20)
);

CREATE TABLE T_K_RESTP_BEH_ARSAK(
    k_restp_beh_arsak VARCHAR(20) PRIMARY KEY
);

CREATE TABLE T_LONN_VEKST_REG(
    lonnsvekst_reg_id INTEGER PRIMARY KEY,
    reguleringsbelop  NUMERIC,
    regulering_dato   date
);

CREATE TABLE T_OMSORG(
    omsorg_id  INTEGER PRIMARY KEY,
    person_id  INTEGER,
    ar         INTEGER,
    k_omsorg_t VARCHAR(20),
    k_omsorg_s VARCHAR(20),
    k_kilde_t  VARCHAR(20)
);

CREATE TABLE T_OMSORG_OPPTJ(
    omsorg_opptj_id    INTEGER PRIMARY KEY,
    belop              NUMERIC,
    ar                 INTEGER,
    oms_opptj_innskudd NUMERIC
);

CREATE TABLE T_OPPTJN(
    opptjn_id        INTEGER PRIMARY KEY,
    person_id_opptjn INTEGER,
    opptjn_ar        INTEGER,
    pgi_anvendt      NUMERIC,
    poeng            NUMERIC,
    max_uforegrad    NUMERIC,
    k_opptjn_t       VARCHAR(20),
    k_opptjn_status  VARCHAR(20),
    k_kilde_t        VARCHAR(20)
);

CREATE TABLE T_PERSON(
    person_id INTEGER PRIMARY KEY,
    fnr_fk    VARCHAR(11)
);

CREATE TABLE T_UFORE_OPPTJ(
    ufore_opptj_id      INTEGER PRIMARY KEY,
    belop               NUMERIC,
    ar                  INTEGER,
    ufg                 NUMERIC,
    antatt_inntekt      NUMERIC,
    yug                 NUMERIC,
    antatt_inntekt_yrke NUMERIC,
    yrkesskade          VARCHAR(1),
    uforetrygd          VARCHAR(1),
    uforear             VARCHAR(1)
);