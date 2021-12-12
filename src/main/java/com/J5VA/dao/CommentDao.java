package com.J5VA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.J5VA.entity.Comment;
import com.J5VA.entity.Favorite;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {
	@Query("SELECT o FROM Comment o WHERE o.comment_food.food_id=?1")
	List<Comment> getCommentsByFoodId(Integer food_id);
}
