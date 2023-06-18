package com.common.code.challenge.system.data.init.repository;

import com.common.code.challenge.system.data.init.model.CityReconstruction;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CityReconstructionBatchRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void bulkInsert(List<CityReconstruction> cityReconstructions) {
        String sql = createSQL();
        SqlParameterSource[] sqlParameterSources = generateParameters(cityReconstructions);
        namedParameterJdbcTemplate.batchUpdate(sql, sqlParameterSources);
    }

    private String createSQL() {
        return "insert into city_reconstruction (" +
                " bsns_pk, " +
                " bsns, " +
                " gu_nm, " +
                " bjdon_nm, " +
                " btyp_nm," +
                " step_se_nm," +
                " cafe_nm," +
                " reprsnt_jibun," +
                " progrs_sttus," +
                " cafe_sttus," +
                " zone_nm," +
                " zone_adres," +
                " zone_ar," +
                " totar," +
                " cty_plan_spfc_nm," +
                " cty_plan_spcfc_nm," +
                " lad_bldlnd_ar," +
                " lad_road_ar," +
                " lad_park_ar," +
                " lad_greens_ar," +
                " lad_pbspce_ar," +
                " lad_schul_ar," +
                " lad_etc_ar," +
                " bildng_prpos_nm," +
                " bildng_bdtldr," +
                " bildng_flrspcer," +
                " bildng_hg," +
                " bildng_ground_floor_co," +
                " bildng_undgrnd_floor_co," +
                " sum_bildng_co," +
                " bildng_60_co," +
                " bildng_60_85_co," +
                " bildng_85_co," +
                " bildng_rm," +
                " locimg01," +
                " locimg02," +
                " locimg03," +
                " created_at," +
                " modified_at) " +
                " values (" +
                ":bsns_pk, " +
                ":bsns, " +
                ":gu_nm, " +
                ":bjdon_nm, " +
                ":btyp_nm, " +
                ":step_se_nm, " +
                ":cafe_nm, " +
                ":reprsnt_jibun, " +
                ":progrs_sttus, " +
                ":cafe_sttus, " +
                ":zone_nm, " +
                ":zone_adres, " +
                ":zone_ar, " +
                ":totar, " +
                ":cty_plan_spfc_nm, " +
                ":cty_plan_spcfc_nm, " +
                ":lad_bldlnd_ar, " +
                ":lad_road_ar, " +
                ":lad_park_ar, " +
                ":lad_greens_ar, " +
                ":lad_pbspce_ar, " +
                ":lad_schul_ar, " +
                ":lad_etc_ar, " +
                ":bildng_prpos_nm, " +
                ":bildng_bdtldr, " +
                ":bildng_flrspcer, " +
                ":bildng_hg, " +
                ":bildng_ground_floor_co, " +
                ":bildng_undgrnd_floor_co, " +
                ":sum_bildng_co, " +
                ":bildng_60_co, " +
                ":bildng_60_85_co, " +
                ":bildng_85_co, " +
                ":bildng_rm, " +
                ":locimg01, " +
                ":locimg02, " +
                ":locimg03, " +
                "now(), " +
                "now())";
    }

    private SqlParameterSource[] generateParameters(List<CityReconstruction> cityReconstructions) {
        SqlParameterSource[] batchParams = new SqlParameterSource[cityReconstructions.size()];
        for (int i = 0; i < cityReconstructions.size(); i++) {
            batchParams[i] = new BeanPropertySqlParameterSource(cityReconstructions.get(i));
        }
        return batchParams;
    }

}
