package com.J5VA.implement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.J5VA.dao.FoodDao;
import com.J5VA.entity.Food;

@ExtendWith(MockitoExtension.class)
public class FoodImplementTest {

	@Mock
	FoodDao foodDao;

	@InjectMocks
	FoodImplement foodService;

	@Test
	void test_FoodGetAll_pass() {
		List<Food> mockFoods = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			mockFoods.add(new Food());
		}

		when(foodDao.findAll()).thenReturn(mockFoods);
		List<Food> actualFoods = foodService.findAll();
		assertThat(actualFoods.size()).isEqualTo(mockFoods.size());
		verify(foodDao).findAll();
	}

	@Test
	void test_findFoodById_fail() {
		Integer foodId = 3;
		Food mockFoods = new Food();
		when(foodDao.findById(foodId).get()).thenReturn(mockFoods);
		Food actualFoods = foodService.findById(foodId);
		assertThat(actualFoods).isEqualTo(mockFoods);
		verify(foodDao).findAll();
	}
	

}
