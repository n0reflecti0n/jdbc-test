package com.example.jdbctest.output.persistence.model.projection;

public record UserSimpleProjection(

        Long id,
        String name,
        String roleName
) {
}
