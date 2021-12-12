package com.J5VA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.J5VA.entity.Account;
import com.J5VA.entity.Favorite;
import com.J5VA.entity.FoodRate;

@Repository
public interface FavoriteDao extends JpaRepository<Favorite, Integer> {
	@Query("SELECT o FROM Favorite o WHERE o.favorite_acc=?1")
	List<Favorite> findAllByAccount(Account account);

	@Query("SELECT o FROM Favorite o WHERE o.favorite_f.food_id=?1")
	Favorite findFavoriteByFood(Integer id);

	@Query("SELECT new FoodRate(o.favorite_f.food_id, COUNT(o.favorite_f.food_id)) FROM Favorite o GROUP BY o.favorite_f.food_id ORDER BY COUNT(o.favorite_f.food_id) DESC ")
	List<FoodRate> getFoodRates();
}
