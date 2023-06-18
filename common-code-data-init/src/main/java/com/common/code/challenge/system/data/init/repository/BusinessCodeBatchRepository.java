package com.common.code.challenge.system.data.init.repository;

import com.common.code.challenge.system.data.init.model.BusinessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class BusinessCodeBatchRepository {
    private final JdbcTemplate jdbcTemplate;

    public void bulkInsert(List<BusinessCode> businessCodes) {
        final String sql = "INSERT INTO business_code(code, name, used, order_number, created_at, modified_at) VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, businessCodes.get(i).getCode());
                ps.setString(2, businessCodes.get(i).getName());
                ps.setBoolean(3, true);
                ps.setInt(4, businessCodes.get(i).getOrderNumber());
                ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
                ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
            }

            @Override
            public int getBatchSize() {
                return businessCodes.size();
            }
        });

    }
}
