package com.common.code.challenge.system.data.init.repository;

import com.common.code.challenge.system.data.init.model.AreaCode;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Repository
public class AreaBatchRepository {
    private final JdbcTemplate jdbcTemplate;
    public void bulkInsert(List<AreaCode> areaCodes, AreaCode parent) {
        final String sql = "INSERT INTO area_code(code, parent_code, name, depth, used, created_at, modified_at) VALUES(?, ?, ?, ?, ?, ?, ?)";
        final String parentCode = isNull(parent) ? null : parent.getCode();

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, areaCodes.get(i).getCode());
                ps.setString(2, parentCode);
                ps.setString(3, areaCodes.get(i).getName());
                ps.setInt(4, areaCodes.get(i).getDepth());
                ps.setBoolean(5, true);
                ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
                ps.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            }

            @Override
            public int getBatchSize() {
                return areaCodes.size();
            }
        });
    }
}
