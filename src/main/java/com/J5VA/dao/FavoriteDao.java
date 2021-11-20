package com.J5VA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.J5VA.entity.Account;
import com.J5VA.entity.Favorite;

@Repository
public interface FavoriteDao extends JpaRepository<Favorite, Integer> {
	@Query("SELECT o FROM Favorite o WHERE o.favorite_acc=?1")
	List<Favorite> findAllByAccount(Account account);
}
