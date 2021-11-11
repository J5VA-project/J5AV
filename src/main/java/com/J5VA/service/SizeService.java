package com.J5VA.service;

import java.util.List;

import com.J5VA.entity.Size;

public interface SizeService {

	List<Size> findAll();

	Size findById(Integer id);

	Size create(Size size);

	Size update(Size size);

	void delete(Integer id);
}
