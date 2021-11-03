package com.J5VA.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.J5VA.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer>{

}
