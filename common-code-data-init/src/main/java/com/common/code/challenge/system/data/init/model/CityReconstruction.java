package com.common.code.challenge.system.data.init.model;

import com.common.code.challenge.system.common.domain.valueobject.CafeStatus;
import lombok.Getter;

@Getter
public class CityReconstruction {
    private String bsns_pk;
    private String bsns;
    private String gu_nm;
    private String bjdon_nm;
    private String btyp_nm;
    private String step_se_nm;
    private String cafe_nm;
    private String reprsnt_jibun;
    private String progrs_sttus;
    private String cafe_sttus;
    private String zone_nm;
    private String zone_adres;
    private String zone_ar;
    private String totar;
    private String cty_plan_spfc_nm;
    private String cty_plan_spcfc_nm;
    private String lad_bldlnd_ar;
    private String lad_road_ar;
    private String lad_park_ar;
    private String lad_greens_ar;
    private String lad_pbspce_ar;
    private String lad_schul_ar;
    private String lad_etc_ar;
    private String bildng_prpos_nm;
    private String bildng_bdtldr;
    private String bildng_flrspcer;
    private String bildng_hg;
    private String bildng_ground_floor_co;
    private String bildng_undgrnd_floor_co;
    private String sum_bildng_co;
    private String bildng_60_co;
    private String bildng_60_85_co;
    private String bildng_85_co;
    private String bildng_rm;
    private String locimg01;
    private String locimg02;
    private String locimg03;

    public CityReconstruction(String bsns_pk, String gu_nm, String bjdon_nm, String btyp_nm, String step_se_nm, String cafe_nm, String reprsnt_jibun, String progrs_sttus, String cafe_sttus, String zone_nm, String zone_adres, String zone_ar, String totar, String cty_plan_spfc_nm, String cty_plan_spcfc_nm, String lad_bldlnd_ar, String lad_road_ar, String lad_park_ar, String lad_greens_ar, String lad_pbspce_ar, String lad_schul_ar, String lad_etc_ar, String bildng_prpos_nm, String bildng_bdtldr, String bildng_flrspcer, String bildng_hg, String bildng_ground_floor_co, String bildng_undgrnd_floor_co, String sum_bildng_co, String bildng_60_co, String bildng_60_85_co, String bildng_85_co, String bildng_rm, String locimg01, String locimg02, String locimg03) {
        this.bsns_pk = bsns_pk;
        this.bsns = bsns_pk.substring(0, 5) + "00000";
        this.gu_nm = gu_nm;
        this.bjdon_nm = bjdon_nm;
        this.btyp_nm = btyp_nm;
        this.step_se_nm = step_se_nm;
        this.cafe_nm = cafe_nm;
        this.reprsnt_jibun = reprsnt_jibun;
        this.progrs_sttus = progrs_sttus;
        this.cafe_sttus = CafeStatus.getName(cafe_sttus);
        this.zone_nm = zone_nm;
        this.zone_adres = zone_adres;
        this.zone_ar = zone_ar;
        this.totar = totar;
        this.cty_plan_spfc_nm = cty_plan_spfc_nm;
        this.cty_plan_spcfc_nm = cty_plan_spcfc_nm;
        this.lad_bldlnd_ar = lad_bldlnd_ar;
        this.lad_road_ar = lad_road_ar;
        this.lad_park_ar = lad_park_ar;
        this.lad_greens_ar = lad_greens_ar;
        this.lad_pbspce_ar = lad_pbspce_ar;
        this.lad_schul_ar = lad_schul_ar;
        this.lad_etc_ar = lad_etc_ar;
        this.bildng_prpos_nm = bildng_prpos_nm;
        this.bildng_bdtldr = bildng_bdtldr;
        this.bildng_flrspcer = bildng_flrspcer;
        this.bildng_hg = bildng_hg;
        this.bildng_ground_floor_co = bildng_ground_floor_co;
        this.bildng_undgrnd_floor_co = bildng_undgrnd_floor_co;
        this.sum_bildng_co = sum_bildng_co;
        this.bildng_60_co = bildng_60_co;
        this.bildng_60_85_co = bildng_60_85_co;
        this.bildng_85_co = bildng_85_co;
        this.bildng_rm = bildng_rm;
        this.locimg01 = locimg01;
        this.locimg02 = locimg02;
        this.locimg03 = locimg03;
    }

    public void setBtyp_nm(String btyp_nm) {
        this.btyp_nm = btyp_nm;
    }
}
