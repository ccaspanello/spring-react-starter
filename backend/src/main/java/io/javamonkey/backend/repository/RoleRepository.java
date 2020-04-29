package io.javamonkey.backend.repository;

import io.javamonkey.backend.model.ERole;
import io.javamonkey.backend.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {

    Optional<Role> findByName(ERole name);

}