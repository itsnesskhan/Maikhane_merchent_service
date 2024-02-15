package com.maikhane.mercentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.maikhane.mercentservice.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
