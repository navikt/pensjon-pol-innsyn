INSERT INTO T_BEHOLDNING VALUES (1, 1, 1, 1, 1, 1, 1, 'k_beholdning_t', 'k_beholdning_s', 'k_restp_beh_arsak', '2019.11.01', '2019.12.31', 1.23, 2.34, 3.45, 4.56);

INSERT INTO T_DAGPENGER VALUES (1, 1.23, 2.34, 3.45, 4.56, 2019, 'k_dagpenger_t', 'k_dagpenger_s', 'k_kilde_t', 'k_rapport_t');

INSERT INTO T_DAGPENGER_OPPTJ VALUES (1, 1.23, 2019, 2.34);

INSERT INTO T_F_TJEN_OPPTJ VALUES (1, 2019);

INSERT INTO T_F_TJEN_TOT VALUES (1, '2019.12.31', '2019.12.31', 'k_kilde_t', 'k_rapport_t', 'k_f_tjen_tot_s');

INSERT INTO T_FPP_AFP VALUES (1, 1, 123.45, 32.1, 'AFP 1', '2001.01.01', '2029.12.31');

INSERT INTO T_INNTEKT VALUES (1, 'k_inntekt_t', 1, 2019, 'k_inntekt_status', '2019.12.31', 1.23, 'k_kilde_t');

INSERT INTO T_INNTEKT_OPPTJ VALUES (1, 1, 1, 1.23);

INSERT INTO T_K_BEHOLDNING_S VALUES ('k_beholdning_s', 'Beholdningsstatus 1');

INSERT INTO T_K_BEHOLDNING_T VALUES ('k_beholdning_t', 'Beholdningstype 1');

INSERT INTO T_K_DAGPENGER_S VALUES ('k_dagpenger_s', 'Dagpengerstatus 1');

INSERT INTO T_K_DAGPENGER_T VALUES ('k_dagpenger_t', 'Dagpengertype 1');

INSERT INTO T_K_F_TJEN_TOT_S VALUES ('k_f_tjen_tot_s', '1.gangstj.status 1');

INSERT INTO T_K_FPP_AFP_S VALUES (1, 'k_fpp_afp_s', 'FPP-AFP-status 1');

INSERT INTO T_K_INNTEKT_STATUS VALUES ('k_inntekt_status', 'Inntektsstatus 1');

INSERT INTO T_K_INNTEKT_T VALUES ('k_inntekt_t', 'Inntektstype 1');

INSERT INTO T_K_KILDE_T VALUES ('k_kilde_t', 'Kildetype 1');

INSERT INTO T_K_OMSORG_S VALUES ('k_omsorg_s', 'Omsorgsstatus 1');

INSERT INTO T_K_OMSORG_T VALUES ('k_omsorg_t', 'Omsorgstype 1');

INSERT INTO T_K_OPPTJN_STATUS VALUES ('k_opptjn_status', 'Opptjeningsstatus 1');

INSERT INTO T_K_OPPTJN_T VALUES ('k_opptjn_t', 'Opptjeningstype 1');

INSERT INTO T_K_RAPPORT_T VALUES ('k_rapport_t', 'Rapporttype 1');

INSERT INTO T_K_RESTP_BEH_ARSAK VALUES ('k_restp_beh_arsak');

INSERT INTO T_LONN_VEKST_REG VALUES (1, 1.23, '2019.12.31');

INSERT INTO T_OMSORG VALUES (1, 2019, 'k_omsorg_t', 'k_omsorg_s', 'k_kilde_t');

INSERT INTO T_OMSORG_OPPTJ VALUES (1, 2019, 1.23, 2.34);

INSERT INTO T_OPPTJN VALUES (1, 2019, 1.23, 2.34, 3.45, 'k_opptjn_t', 'k_opptjn_status', 'k_kilde_t');

INSERT INTO T_PERSON VALUES (1, '01029312345');

INSERT INTO T_UFORE_OPPTJ VALUES (1, 1.23, 2019, 2.34, 3.45, 4.56, '1', '0', '1', 7.89);
