package com.example.jdbctest.service;

import com.example.jdbctest.output.persistence.model.UserEntity;
import com.example.jdbctest.output.persistence.model.projection.UserProjection;
import com.example.jdbctest.output.persistence.model.projection.UserSimpleProjection;
import com.example.jdbctest.output.persistence.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {

    private final UserRepository userRepository;

    @PostConstruct
    void init() {
        final Optional<UserEntity> userEntity = userRepository.findByName("name1");
        final Optional<UserSimpleProjection> userSimpleProjection = userRepository.findUserSimpleProjectionById(1L);
        final Optional<UserProjection> userProjection = userRepository.findUserProjectionById(1L);

        log.info("{}", userEntity);
        log.info("{}", userSimpleProjection);
        log.info("{}", userProjection);
    }
}
