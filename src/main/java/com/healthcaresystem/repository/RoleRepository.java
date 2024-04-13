package com.healthcaresystem.repository;

import com.healthcaresystem.entity.HealthRecord;
import com.healthcaresystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
