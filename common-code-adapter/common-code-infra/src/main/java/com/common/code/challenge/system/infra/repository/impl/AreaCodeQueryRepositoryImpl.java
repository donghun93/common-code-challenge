package com.common.code.challenge.system.infra.repository.impl;

import com.common.code.challenge.system.infra.entity.AreaCodeEntity;
import com.common.code.challenge.system.infra.repository.AreaCodeQueryRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

import static com.common.code.challenge.system.infra.entity.QAreaCodeEntity.areaCodeEntity;

@RequiredArgsConstructor
@Repository
public class AreaCodeQueryRepositoryImpl implements AreaCodeQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<AreaCodeEntity> findAllMainAreaCode() {
        return queryFactory
                .select(areaCodeEntity)
                .from(areaCodeEntity)
                .where(
                        eqDepth(1),
                        isActive()
                )
                .fetch();
    }

    @Override
    public List<AreaCodeEntity> findSubAreaCodeByCode(String parentCode) {
        return queryFactory
                .select(areaCodeEntity)
                .from(areaCodeEntity)
                .where(
                        eqParentAreaCode(parentCode),
                        isActive()
                )
                .fetch();
    }

    @Override
    public Optional<AreaCodeEntity> findByAreaCode(String code) {
        return Optional.ofNullable(queryFactory
                .select(areaCodeEntity)
                .from(areaCodeEntity)
                .where(
                        areaCodeEntity.code.eq(code),
                        isActive()
                )
                .fetchOne());
    }

    private BooleanExpression eqParentAreaCode(String code) {
        return StringUtils.hasText(code) ? areaCodeEntity.parent.code.eq(code) : null;
    }

    private BooleanExpression isActive() {
        return areaCodeEntity.used.eq(true);
    }

    private BooleanExpression eqDepth(int depth) {
        return areaCodeEntity.depth.eq(depth);
    }
}
