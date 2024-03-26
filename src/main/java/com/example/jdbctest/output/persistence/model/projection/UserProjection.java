package com.example.jdbctest.output.persistence.model.projection;

public record UserProjection(

        Long id,
        String name,
        RoleProjection role
) {
}
