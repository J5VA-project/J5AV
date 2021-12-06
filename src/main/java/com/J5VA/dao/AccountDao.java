package com.J5VA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.J5VA.entity.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, String> {

	@Query("SELECT o FROM Account o WHERE o.username = ?1")
	Account findByUsername(String username);

	@Query("SELECT count(o) FROM Account o WHERE DATEDIFF(yy,o.birthdate,GETDATE()) = ?1")
	Integer findByAge(Integer age);

	@Query("SELECT distinct YEAR(GETDATE())-YEAR(o.birthdate) FROM  Account o WHERE YEAR(GETDATE())-YEAR(o.birthdate) IS NOT NULL")
	List<Integer> listAgeAccount();
	
	@Query("SELECT o FROM Account o")
	List<Account> getMostBuy(Integer month, Integer year);
}
