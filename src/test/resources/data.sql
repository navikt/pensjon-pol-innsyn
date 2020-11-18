INSERT INTO T_BEHOLDNING(beholdning_id, person_id, inntekt_opptj_id, f_tjen_opptj_id, dagpenger_opptj_id, omsorg_opptj_id,
                         ufore_opptj_id, lonnsvekst_reg_id, k_beholdning_t, k_beholdning_s, k_restp_beh_arsak, dato_fom,
                         dato_tom, belop, beh_grlag, beh_grlag_avkortet, beh_innskudd)
VALUES (1, 1, 1, 1, 1, 1, 1, 1, 'k_beholdning_t', 'k_beholdning_s', 'k_restp_beh_arsak', TO_DATE('2019.11.01', 'YYYY.MM.DD'), TO_DATE('2019.12.31', 'YYYY.MM.DD'), 1.23,
        2.34, 3.45, 4.56);

INSERT INTO T_DAGPENGER(dagpenger_id, person_id, ferietillegg, barnetillegg, dagpenger, uavkortet_dp_grlag, ar, k_dagpenger_t,
                        k_dagpenger_s, k_kilde_t, k_rapport_t)
VALUES (1, 1, 1.23, 2.34, 3.45, 4.56, 2019, 'k_dagpenger_t', 'k_dagpenger_s', 'k_kilde_t', 'k_rapport_t');

INSERT INTO T_DAGPENGER_OPPTJ(dagpenger_opptj_id, belop_ordinar, ar, belop_fiskere)
VALUES (1, 1.23, 2019, 2.34);

INSERT INTO T_F_TJEN_OPPTJ(f_tjen_opptj_id, ar)
VALUES (1, 2019);

INSERT INTO T_F_TJEN_TOT(f_tjen_tot_id, person_id, dato_tjenestestart, dato_dimittering, k_kilde_t, k_rapport_t, k_f_tjen_tot_s)
VALUES (1, 1, TO_DATE('2019.12.31', 'YYYY.MM.DD'), TO_DATE('2019.12.31', 'YYYY.MM.DD'), 'k_kilde_t', 'k_rapport_t', 'k_f_tjen_tot_s');

INSERT INTO T_FPP_AFP(fpp_afp_id, k_fpp_afp_s, person_id, afp_fpp, afp_pensjonsgrad, afp_type, virk_fom, virk_tom)
VALUES (1, 1, 1, 123.45, 32.1, 'AFP 1', TO_DATE('2001.01.01', 'YYYY.MM.DD'), TO_DATE('2029.12.31', 'YYYY.MM.DD'));

INSERT INTO T_INNTEKT(inntekt_id, k_inntekt_t, person_id, inntekt_ar, k_inntekt_status, pi_rappdato, belop, k_kilde_t)
VALUES (1, 'k_inntekt_t', 1, 2019, 'k_inntekt_status', TO_DATE('2019.12.31', 'YYYY.MM.DD'), 1.23, 'k_kilde_t');

INSERT INTO T_INNTEKT_OPPTJ(inntekt_opptj_id, inntekt_id, ar, belop)
VALUES (1, 1, 1, 1.23);

INSERT INTO T_K_BEHOLDNING_S(k_beholdning_s, dekode)
VALUES ('k_beholdning_s', 'Beholdningsstatus 1');

INSERT INTO T_K_BEHOLDNING_T(k_beholdning_t, dekode)
VALUES ('k_beholdning_t', 'Beholdningstype 1');

INSERT INTO T_K_DAGPENGER_S(k_dagpenger_s, dekode)
VALUES ('k_dagpenger_s', 'Dagpengerstatus 1');

INSERT INTO T_K_DAGPENGER_T(k_dagpenger_t, dekode)
VALUES ('k_dagpenger_t', 'Dagpengertype 1');

INSERT INTO T_K_F_TJEN_TOT_S(k_f_tjen_tot_s, dekode)
VALUES ('k_f_tjen_tot_s', '1.gangstj.status 1');

INSERT INTO T_K_FPP_AFP_S(k_fpp_afp_s, status, dekode)
VALUES (1, 'k_fpp_afp_s', 'FPP-AFP-status 1');

INSERT INTO T_K_INNTEKT_STATUS(k_inntekt_status, dekode)
VALUES ('k_inntekt_status', 'Inntektsstatus 1');

INSERT INTO T_K_INNTEKT_T(k_inntekt_t, dekode)
VALUES ('k_inntekt_t', 'Inntektstype 1');

INSERT INTO T_K_KILDE_T(k_kilde_t, dekode)
VALUES ('k_kilde_t', 'Kildetype 1');

INSERT INTO T_K_OMSORG_S(k_omsorg_s, dekode)
VALUES ('k_omsorg_s', 'Omsorgsstatus 1');

INSERT INTO T_K_OMSORG_T(k_omsorg_t, dekode)
VALUES ('k_omsorg_t', 'Omsorgstype 1');

INSERT INTO T_K_OPPTJN_STATUS(k_opptjn_status, dekode)
VALUES ('k_opptjn_status', 'Opptjeningsstatus 1');

INSERT INTO T_K_OPPTJN_T(k_opptjn_t, dekode)
VALUES ('k_opptjn_t', 'Opptjeningstype 1');

INSERT INTO T_K_RAPPORT_T(k_rapport_t, dekode)
VALUES ('k_rapport_t', 'Rapporttype 1');

INSERT INTO T_K_RESTP_BEH_ARSAK(k_restp_beh_arsak)
VALUES ('k_restp_beh_arsak');

INSERT INTO T_LONN_VEKST_REG(lonnsvekst_reg_id, reguleringsbelop, regulering_dato)
VALUES (1, 1.23, TO_DATE('2019.12.31', 'YYYY.MM.DD'));

INSERT INTO T_OMSORG(omsorg_id, person_id, ar, k_omsorg_t, k_omsorg_s, k_kilde_t)
VALUES (1, 1, 2019, 'k_omsorg_t', 'k_omsorg_s', 'k_kilde_t');

INSERT INTO T_OMSORG_OPPTJ(omsorg_opptj_id, ar, belop, oms_opptj_innskudd)
VALUES (1, 2019, 1.23, 2.34);

INSERT INTO T_OPPTJN(opptjn_id, person_id_opptjn, opptjn_ar, pgi_anvendt, poeng, max_uforegrad, k_opptjn_t, k_opptjn_status,
                     k_kilde_t)
VALUES (1, 1, 2019, 1.23, 2.34, 3.45, 'k_opptjn_t', 'k_opptjn_status', 'k_kilde_t');

INSERT INTO T_PERSON(person_id, fnr_fk)
VALUES (1, '01029312345');

INSERT INTO T_UFORE_OPPTJ(ufore_opptj_id, belop, ar, ufg, yug, antatt_inntekt_yrke, yrkesskade, uforetrygd, uforear,
                          antatt_inntekt)
VALUES (1, 1.23, 2019, 2.34, 3.45, 4.56, '1', '0', '1', 7.89);
