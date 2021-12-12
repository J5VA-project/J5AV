package com.J5VA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.J5VA.entity.Account;
import com.J5VA.entity.Comment;
import com.J5VA.entity.Favorite;

@Repository
public interface CommentDao extends JpaRepository<Favorite, Integer> {
	@Query("SELECT o FROM Comment o WHERE o.favorite_f.food_id=?1")
	List<Comment> getCommentsByFoodId(Account account);
}
