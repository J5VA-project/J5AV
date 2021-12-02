package com.J5VA.implement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.J5VA.dao.FoodDao;
import com.J5VA.entity.Food;

@ExtendWith(SpringExtension.class)
public class PageImplementTest {

	@Mock
	FoodDao foodDao;

	@InjectMocks
	FoodImplement foodService;
	
	@Test
	void test_PageFood_fail1() {
		Integer showPageNumber = 6;
		String name = "ABC";
		String key = "asc";
		Integer pageNumber = 2;
		
		Page<Food> page = foodService .pageFood(Mockito.anyInt(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt());
		
		when(foodService.pageFood(showPageNumber, name, key, pageNumber)).thenReturn(page);
		assertThat(page).isNotEmpty();
		verify(foodService).pageFood(showPageNumber, name, key, pageNumber);
	}
	
	@Test
	void test_PageFood_fail2() {
		Integer showPageNumber = null;
		String name = null;
		String key = null;
		Integer pageNumber = null;
		
		when(foodService.pageFood(showPageNumber, name, key, pageNumber)).thenReturn(foodService.pageFood(7, "Hi", "Chicken", 4));
		verify(foodService).pageFood(showPageNumber, name, key, pageNumber);
	}
	
	@Test
	void test_PageFood_fail3() {
		Integer showPageNumber = 12;
		String name = "HEHE";
		String key = "az";
		Integer pageNumber = 12;
		
		when(foodService.pageFood(showPageNumber, name, key, pageNumber)).thenReturn(foodService.pageFood(7, "Hi", "Chicken", 4));
		verify(foodService).pageFood(showPageNumber, name, key, pageNumber);
	}
	
	@Test
	void test_PageFood_fail4() {
		Integer showPageNumber = 18;
		String name = "HAHA";
		String key = "za";
		Integer pageNumber = 5;
		
		when(foodService.pageFood(showPageNumber, name, key, pageNumber)).thenReturn(foodService.pageFood(7, "Hi", "Chicken", 4));
		verify(foodService).pageFood(showPageNumber, name, key, pageNumber);
	}
	
	@Test
	void test_PageFood_fail5() {
		Integer a = 21;
		String b = "HelloWord";
		String c = "  ";
		Integer d = -12;
		
		when(foodService.pageFood(a, b, c, d)).thenReturn(foodService.pageFood(Mockito.anyInt(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt()));
		verify(foodService).pageFood(null, null, null, null);
	}
	
}
