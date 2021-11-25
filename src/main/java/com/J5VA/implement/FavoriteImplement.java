package com.J5VA.implement;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J5VA.dao.FavoriteDao;
import com.J5VA.entity.Account;
import com.J5VA.entity.Favorite;
import com.J5VA.service.FavoriteService;

@Service
public class FavoriteImplement implements FavoriteService {
	@Autowired
	FavoriteDao dao;

	@Override
	public <S extends Favorite> S save(S entity) {
		return dao.save(entity);
	}

	@Override
	public List<Favorite> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Favorite> findAllById(Iterable<Integer> ids) {
		return dao.findAllById(ids);
	}

	@Override
	public <S extends Favorite> List<S> saveAll(Iterable<S> entities) {
		return dao.saveAll(entities);
	}

	@Override
	public Favorite findById(Integer id) {
		try {
			return dao.findById(id).get();
		} catch (Exception e) {
			e.getMessage();
			return null;
		}

	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public void delete(Favorite entity) {
		dao.delete(entity);
	}

	@Override
	public Favorite create(Favorite favo) {
		return dao.save(favo);
	}

	@Override
	public Favorite update(Favorite favo) {
		return dao.save(favo);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public List<Favorite> findAllByAccount(Account account) {
		return dao.findAllByAccount(account);
	}

	@Override
	public Favorite findFavoriteByFood(Integer id) {
		return dao.findFavoriteByFood(id);
	}
}
