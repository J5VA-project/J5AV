package com.J5VA.implement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.byLessThan;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
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
import com.J5VA.entity.Favorite;

@ExtendWith(MockitoExtension.class)
class FavoriteImplementTest {
	@Mock
	FavoriteDao favoriteDao;

	@InjectMocks
	FavoriteImplement favoriteService;

	@Test
	@Timeout(value = 2000)
	void whenGetAll_shouldReturnList() {
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
	void whenGetInvalidOne_shouldThrowException() {
		Integer invalidFavoriteId = 0;
		when(favoriteDao.findById(invalidFavoriteId)).thenReturn(Optional.ofNullable(null));

		assertThatThrownBy(() -> favoriteService.findById(invalidFavoriteId)).isInstanceOf(Exception.class);

		verify(favoriteDao).findById(invalidFavoriteId);
	}
}
