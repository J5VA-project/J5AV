package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J5VA.dao.CommentDao;
import com.J5VA.entity.Comment;
import com.J5VA.service.CommentService;

@Service
public class CommentImplement implements CommentService {
	@Autowired
	CommentDao dao;

	@Override
	public List<Comment> getCommentsByFoodId(Integer food_id) {
		return dao.getCommentsByFoodId(food_id);
	}

	@Override
	public Comment create(Comment comment) {
		return dao.save(comment);
	}

}
