package com.example.spring04.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring04.domain.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MapRepositoryTest {
	
	@Autowired
	private MapRepository mapRepository;

	@Test
	public void testFindAll() {
		Assertions.assertNotNull(mapRepository);
		log.info("mapRepository = {}", mapRepository);
		
		List<Map> list = mapRepository.findAll();
		Assertions.assertTrue(list.size() > 0);
		for (Map m : list) {
			log.info("{} | {} | {}", m.getAddress(), m.getTitle(), m.getContent());
		}
		
	}
}
