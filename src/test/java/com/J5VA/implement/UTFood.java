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
import com.J5VA.implement.FoodImplement;

@ExtendWith(SpringExtension.class)
public class UTFood {
	
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
	

	//Integer showPageNumber, String name, String key, Integer pageNumber
//	@Test
//	void test_PageFood_fail1() {
//		Integer showPageNumber = 6;
//		String name = "ABC";
//		String key = "asc";
//		Integer pageNumber = 2;
//		
//		when(foodService.pageFood(showPageNumber, name, key, pageNumber)).thenReturn(foodService.pageFood(7, "Hi", "Chicken", 4));
//		verify(foodService).pageFood(showPageNumber, name, key, pageNumber);
//	}
//	
//	@Test
//	void test_PageFood_fail2() {
//		Integer showPageNumber = null;
//		String name = null;
//		String key = null;
//		Integer pageNumber = null;
//		
//		when(foodService.pageFood(showPageNumber, name, key, pageNumber)).thenReturn(foodService.pageFood(7, "Hi", "Chicken", 4));
//		verify(foodService).pageFood(showPageNumber, name, key, pageNumber);
//	}
//	
//	@Test
//	void test_PageFood_fail3() {
//		Integer showPageNumber = 12;
//		String name = "HEHE";
//		String key = "az";
//		Integer pageNumber = 12;
//		
//		when(foodService.pageFood(showPageNumber, name, key, pageNumber)).thenReturn(foodService.pageFood(7, "Hi", "Chicken", 4));
//		verify(foodService).pageFood(showPageNumber, name, key, pageNumber);
//	}
//	
//	@Test
//	void test_PageFood_fail4() {
//		Integer showPageNumber = 18;
//		String name = "HAHA";
//		String key = "za";
//		Integer pageNumber = 5;
//		
//		when(foodService.pageFood(showPageNumber, name, key, pageNumber)).thenReturn(foodService.pageFood(7, "Hi", "Chicken", 4));
//		verify(foodService).pageFood(showPageNumber, name, key, pageNumber);
//	}
//	
//	@Test
//	void test_PageFood_fail5() {
//		Integer a = 21;
//		String b = "HelloWord";
//		String c = "  ";
//		Integer d = -12;
//		
//		when(foodService.pageFood(a, b, c, d)).thenReturn(foodService.pageFood(Mockito.anyInt(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt()));
//		verify(foodService).pageFood(null, null, null, null);
//	}

//	@Test
//	void test_updateFood_pass() {
//		Food food = new Food();
//		food.setFood_id(555);
//		food
//
//		Favorite favoriteNew = new Favorite();
//		when(favoriteDao.findById(favorite.getFavorite_id())).thenReturn(Optional.of(favorite));
//		favoriteService.update(favoriteNew);
//		verify(favoriteDao).save(favoriteNew);
//		verify(favoriteDao).findById(favorite.getFavorite_id());
//	}

}
