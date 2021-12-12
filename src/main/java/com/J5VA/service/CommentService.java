package com.J5VA.service;

import java.util.List;

import com.J5VA.entity.Comment;

public interface CommentService {
	List<Comment> getCommentsByFoodId(Integer food_id);

	Comment create(Comment comment);
}
