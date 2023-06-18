package com.common.code.challenge.system.infra.repository.impl;

import com.common.code.challenge.system.domain.application.service.dto.CityReconstructionAndBusinessItemDto;
import com.common.code.challenge.system.infra.repository.CityReconstructionQueryRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.common.code.challenge.system.common.domain.valueobject.CafeStatus.OPERATE;
import static com.common.code.challenge.system.infra.entity.QAreaCodeEntity.areaCodeEntity;
import static com.common.code.challenge.system.infra.entity.QBusinessCodeEntity.businessCodeEntity;
import static com.common.code.challenge.system.infra.entity.QCityReconstructionEntity.cityReconstructionEntity;

@RequiredArgsConstructor
@Repository
public class CityReconstructionQueryRepositoryImpl implements CityReconstructionQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<CityReconstructionAndBusinessItemDto> getCityReconstructionsStatistics(int depth, String code) {
        return queryFactory
                .select(Projections.constructor(CityReconstructionAndBusinessItemDto.class,
                        cityReconstructionEntity.businessCode.code.count(),
                        cityReconstructionEntity.businessCode.name
                ))
                .from(cityReconstructionEntity)
                .join(cityReconstructionEntity.areaCode, areaCodeEntity)
                .on(
                        eqAreaCodeAndDepth(depth, code),
                        areaCodeEntity.used.eq(true))
                .join(cityReconstructionEntity.businessCode, businessCodeEntity)
                .on(businessCodeEntity.used.eq(true))
                .where(
                        cityReconstructionEntity.areaCode.used.eq(true),
                        cityReconstructionEntity.cafeStatus.eq(OPERATE)
                )
                .groupBy(cityReconstructionEntity.businessCode)
                .fetch();
    }

    private BooleanExpression eqAreaCodeAndDepth(int depth, String code) {
        if (depth == 1) {
            return areaCodeEntity.parent.code.eq(code);
        } else {
            return areaCodeEntity.code.eq(code);
        }
    }
}
