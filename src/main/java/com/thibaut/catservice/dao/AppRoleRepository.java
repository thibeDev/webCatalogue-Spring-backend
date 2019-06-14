package com.thibaut.catservice.dao;

import com.thibaut.catservice.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    public AppRole findByRole(String role);

}
