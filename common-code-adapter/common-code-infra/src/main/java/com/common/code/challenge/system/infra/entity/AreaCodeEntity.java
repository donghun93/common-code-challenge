package com.common.code.challenge.system.infra.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        name = "area_code",
        uniqueConstraints = @UniqueConstraint(
                name = "area_code_name_uk",
                columnNames = {"name"}
        )
)
@Entity
public class AreaCodeEntity extends BaseTimeEntity {
    @Id
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_code")
    private AreaCodeEntity parent;

    @OneToMany(mappedBy = "parent")
    private List<AreaCodeEntity> children = new ArrayList<>();
    private String name;
    private int depth;
    private boolean used;
}
