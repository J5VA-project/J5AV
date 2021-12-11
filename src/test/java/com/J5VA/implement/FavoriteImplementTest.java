package com.J5VA.implement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.J5VA.dao.FavoriteDao;
import com.J5VA.entity.Account;
import com.J5VA.entity.Favorite;
import com.J5VA.entity.Food;

@ExtendWith(MockitoExtension.class)
class FavoriteImplementTest {
	@Mock
	FavoriteDao favoriteDao;

	@InjectMocks
	FavoriteImplement favoriteService;

	@Test
	@Timeout(value = 2000)
	void test_getAllFavorite_pass() {
		List<Favorite> mockFavorites = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			mockFavorites.add(new Favorite());
		}
		when(favoriteDao.findAll()).thenReturn(mockFavorites);
		List<Favorite> actualFavorites = favoriteService.findAll();
		assertThat(actualFavorites.size()).isEqualTo(mockFavorites.size());
		verify(favoriteDao).findAll();
	}

	@Test
	void test_findFavoriteById_pass() {
		Integer favoritedIdInteger = 1;
		Favorite mockesFavorite = new Favorite();
		when(favoriteDao.findById(favoritedIdInteger)).thenReturn(Optional.of(mockesFavorite));
		Favorite actualFavorite = favoriteService.findById(favoritedIdInteger);
		assertThat(actualFavorite).isEqualTo(mockesFavorite);
		verify(favoriteDao).findById(favoritedIdInteger);
	}

	@Test
	void test_createFavorite_pass() {
		Favorite favorite = new Favorite();
		favorite.setFavorite_id(100);
		when(favoriteDao.save(favorite)).thenReturn(favorite);

		Favorite created = favoriteService.create(favorite);
		assertThat(created.getFavorite_id()).isSameAs(favorite.getFavorite_id());
		verify(favoriteDao).save(favorite);
	}

	@Test
	void test_deleteFavorite_pass() {
		Favorite favorite = new Favorite();
		favorite.setFavorite_id(1);
		when(favoriteDao.findById(favorite.getFavorite_id())).thenReturn(Optional.of(favorite));
		favoriteService.delete(favorite.getFavorite_id());
		verify(favoriteService).delete(favorite.getFavorite_id());
	}

	@Test
	void test_updateFavorite_pass() {
		Favorite favorite = new Favorite();
		favorite.setFavorite_id(1);
		Account account = new Account();
		favorite.setFavorite_acc(account);
		Food food = new Food();
		favorite.setFavorite_f(food);

		Favorite favoriteNew = new Favorite();
		when(favoriteDao.findById(favorite.getFavorite_id())).thenReturn(Optional.of(favorite));
		favoriteService.update(favoriteNew);
		verify(favoriteDao).save(favoriteNew);
		verify(favoriteDao).findById(favorite.getFavorite_id());
	}
}
