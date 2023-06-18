package com.common.code.challenge.system.infra.entity;

import com.common.code.challenge.system.common.domain.valueobject.CafeStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        name = "city_reconstruction",
        uniqueConstraints = @UniqueConstraint(
                name = "city_reconstruction_uk",
                columnNames = "bsnsPk"
        )
)
@Entity
public class CityReconstructionEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bsnsPk;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "bsns")
    private AreaCodeEntity areaCode;
    private String guNm;

    private String bjdonNm;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "btyp_nm")
    private BusinessCodeEntity businessCode;

    private String stepSeNm;
    private String cafeNm;
    private String reprsntJibun;
    private String progrsSttus;

    @Column(name = "cafe_sttus")
    @Enumerated(EnumType.STRING)
    private CafeStatus cafeStatus;

    private String zoneNm;
    private String zoneAdres;
    private String zoneAr;
    private String totar;
    private String ctyPlanSpfcNm;
    private String ctyPlanSpcfcNm;
    private String ladBldlndAr;
    private String ladRoadAr;
    private String ladParkAr;
    private String ladGreensAr;
    private String ladPbspceAr;
    private String ladSchulAr;
    private String ladEtcAr;
    private String bildngPrposNm;
    private String bildngBdtldr;
    private String bildngFlrspcer;
    private String bildngHg;
    private String bildngGroundFloorCo;
    private String bildngUndgrndFloorCo;
    private String sumBildngCo;
    @Column(name = "bildng_60_co")
    private String bildng60Co;
    @Column(name = "bildng_60_85_co")
    private String bildng6085Co;
    @Column(name = "bildng_85_co")
    private String bildng85Co;
    private String bildngRm;
    private String locimg01;
    private String locimg02;
    private String locimg03;

}
