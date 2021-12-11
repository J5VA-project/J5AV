package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.J5VA.dao.SizeDao;
import com.J5VA.entity.Size;
import com.J5VA.service.SizeService;

@Service
public class SizeImplement implements SizeService {
	@Autowired
	SizeDao sizeDao;
	
	@Override
	public List<Size> findAll() {
		return sizeDao.findAll();
	}

	@Override
	public Size findById(Integer id) {
		return sizeDao.findById(id).get();
	}

	@Override
	public Size create(Size size) {
		return sizeDao.save(size);
	}

	@Override
	public Size update(Size size) {
		return sizeDao.save(size);
	}

	@Override
	public void delete(Integer id) {
		sizeDao.deleteById(id);
	}

}
