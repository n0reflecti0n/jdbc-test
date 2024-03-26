package com.example.jdbctest.output.persistence;

import com.example.jdbctest.output.persistence.model.UserEntity;
import com.example.jdbctest.output.persistence.model.projection.UserProjection;
import com.example.jdbctest.output.persistence.model.projection.UserSimpleProjection;
import com.example.jdbctest.output.persistence.rowmapper.UserRowMapper;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ListCrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByName(String name);

    @Query(
            """
            SELECT u.id, u.name, r.name AS role_name
            FROM users u
            JOIN role r ON u.role_id = r.id
            WHERE u.id = :id
            """
    )
    Optional<UserSimpleProjection> findUserSimpleProjectionById(long id);

    @Query(
            value = """
            SELECT u.id, u.name, r.id AS role_id, r.name AS role_name
            FROM users u
            JOIN role r ON u.role_id = r.id
            WHERE u.id = :id
            """,
            rowMapperClass = UserRowMapper.class
    )
    Optional<UserProjection> findUserProjectionById(long id);
}
