package com.otmb.otmbs.repository;

import com.otmb.otmbs.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository  extends  JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);
    Optional<Role> findByUsersId(Long usersId);
}
