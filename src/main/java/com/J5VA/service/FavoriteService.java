package com.J5VA.service;

package com.J5VA.service;

import java.util.List;

import com.J5VA.entity.Account;
import com.J5VA.entity.Favorite;

public interface FavoriteService {
	void delete(Favorite entity);

	void deleteById(Integer id);

	<S extends Favorite> List<S> saveAll(Iterable<S> entities);

	List<Favorite> findAllById(Iterable<Integer> ids);

	List<Favorite> findAll();

	Favorite findById(Integer id);

	Favorite findByIdCustomer(String id);
	List<Favorite> findAllByAccount(Account account);

	<S extends Favorite> S save(S entity);

	Favorite create(Favorite favo);

	Favorite update(Favorite favo);

	void delete(Integer id);


	Favorite findFavoriteByFood(Integer id);
}
