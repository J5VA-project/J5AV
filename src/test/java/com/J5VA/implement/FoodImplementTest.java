package com.J5VA.implement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.J5VA.dao.FoodDao;
import com.J5VA.entity.Food;

@ExtendWith(SpringExtension.class)
public class FoodImplementTest {
	
	@Mock
	FoodDao foodDao;

	@InjectMocks
	FoodImplement foodService;


	@Test
	void test_findFoodById_fail() {
		Integer foodId = 3;
		Food mockFoods = new Food();

		when(foodDao.findById(foodId)).thenReturn(Optional.of(mockFoods));
		Food actualFoods = foodService.findById(foodId);
		assertThat(actualFoods).isEqualTo(mockFoods);
		verify(foodDao).findById(foodId);
	}


	@Test
	void test_createFood_pass() {
		Food food = new Food();
		food.setFood_id(294);
		food.setFood_name("Thit Bo Kobe");
		food.setPrice(10000.0);
		food.setPhoto("photo.jpg");
		
		when(foodService.save(food)).thenReturn(food);

		Food created = foodService.create(food);
		assertThat(created).isSameAs(food);
		verify(foodDao).save(food);
	}

	@Test
	void test_countFood_pass() {
		when(foodDao.countFood()).thenReturn(20);

		int count = foodService.count();
		assertThat(count).isEqualTo(count);
	}
	
	@Test
	void test_getAllFood_pass() {
		List<Food> mockFavorites = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			mockFavorites.add(new Food());
		}
		when(foodDao.findAll()).thenReturn(mockFavorites);
		List<Food> actualFavorites = foodService.findAll();
		assertThat(actualFavorites.size()).isEqualTo(mockFavorites.size());
		verify(foodDao).findAll();
	}


	@Test
	void test_deleteFood_pass() {
		Food food = new Food();
		food.setFood_id(44);

		when(foodDao.findById(food.getFood_id())).thenReturn(Optional.of(food));
		foodService.delete(food.getFood_id());
		verify(foodDao).deleteById(food.getFood_id());
	}
	

	@Test
	void test_updateFood_pass() {
		Food food = new Food();
		food.setFood_name("Ga Ran");
		food.setPrice(36.0);
		food.setPhoto("garan.jpg");

		
		Food foodMock = new Food();
		when(foodDao.findById(food.getFood_id())).thenReturn(Optional.of(food));
		foodService.update(foodMock);
		verify(foodDao).save(foodMock);
	}
}
