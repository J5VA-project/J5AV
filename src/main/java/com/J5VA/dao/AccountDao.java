package com.J5VA.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.J5VA.entity.Account;
@Repository
public interface AccountDao extends JpaRepository<Account, String> {
	
	@Query("SELECT o FROM Account o WHERE o.username = ?1")
	Account findByUsername(String username);
}
