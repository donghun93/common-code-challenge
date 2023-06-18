package com.common.code.challenge.system.infra.entity.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusinessCodeGenerator implements IdentifierGenerator {
    private static final String PREFIX = "BIZ_CD_";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Connection connection = session.connection();
        try {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select count(*) from business_code");

            if (rs.next()) {
                int id = rs.getInt(1) + 1;
                return PREFIX + String.format("%03d", id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}