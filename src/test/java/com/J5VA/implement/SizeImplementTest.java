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

import com.J5VA.dao.SizeDao;
import com.J5VA.entity.Size;

@ExtendWith(MockitoExtension.class)
class SizeImplementTest {
	@Mock
	SizeDao sizeDao;

	@InjectMocks
	SizeImplement sizeImplement;

	@Test
	@Timeout(value = 2000)
	void test_getAllSize_pass() {
		List<Size> mockSizes = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			mockSizes.add(new Size());
		}
		when(sizeDao.findAll()).thenReturn(mockSizes);
		List<Size> actualSizes = sizeImplement.findAll();
		assertThat(actualSizes.size()).isEqualTo(mockSizes.size());
		verify(sizeDao).findAll();
	}

	@Test
	void test_findSizeById_pass() {
		Integer sizeIdInteger = 1;
		Size mockesSize = new Size();
		when(sizeDao.findById(sizeIdInteger)).thenReturn(Optional.of(mockesSize));
		Size actualSizes = sizeImplement.findById(sizeIdInteger);
		assertThat(actualSizes).isEqualTo(mockesSize);
		verify(sizeDao).findById(sizeIdInteger);
	}

	@Test
	void test_createsize_pass() {
		Size size = new Size();
		size.setSize_id(100);
		when(sizeDao.save(size)).thenReturn(size);
		Size created = sizeImplement.create(size);
		assertThat(created.getSize_id()).isSameAs(size.getSize_id());
		verify(sizeDao).save(size);
	}

	@Test
	void test_deleteSize_pass() {
		Size mockesSize = new Size();
		mockesSize.setSize_id(1);
		sizeDao.delete(mockesSize);
		
		Size sizeDelete = new Size();
		sizeImplement.delete(sizeDelete.getSize_id());
		assertThat(mockesSize).isNotIn(sizeDelete);
			
		verify(sizeDao).delete(mockesSize);
	}

	@Test
	void test_Update_pass() {
		Size mockesSize = new Size();
		mockesSize.setSize_id(1);
		mockesSize.setName("HAHA");
		when(sizeDao.save(mockesSize)).thenReturn(mockesSize);
		Size sizeUpdate = new Size();

		sizeUpdate.setSize_id(1);
		sizeUpdate.setName("HAHA");

		sizeImplement.update(sizeUpdate);
		assertThat(mockesSize.getName()).isSameAs(sizeUpdate.getName());
		verify(sizeDao).save(mockesSize);
	}

}
