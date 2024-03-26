package com.example.jdbctest.output.persistence.rowmapper;

import com.example.jdbctest.output.persistence.model.projection.RoleProjection;
import com.example.jdbctest.output.persistence.model.projection.UserProjection;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserProjection> {

    @Override
    public UserProjection mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        Long roleId = rs.getLong("role_id");
        String roleName = rs.getString("role_name");
        RoleProjection role = new RoleProjection(roleId, roleName);
        return new UserProjection(id, name, role);
    }
}
