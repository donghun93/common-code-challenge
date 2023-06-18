package com.common.code.challenge.system.infra.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        name = "business_code",
        uniqueConstraints = @UniqueConstraint(
                name = "business_code_name_uk",
                columnNames = {"name"}
        )
)
@Entity
public class BusinessCodeEntity extends BaseTimeEntity {

    @Id
    @GenericGenerator(
            name = "codeGenerator",
            strategy = "com.common.code.challenge.system.infra.entity.generator.BusinessCodeGenerator"
    )
    @GeneratedValue(generator = "codeGenerator")
    private String code;
    private String name;
    private boolean used;
    private int orderNumber;
}
