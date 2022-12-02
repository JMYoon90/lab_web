package com.example.spring04.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring04.domain.Map;
import com.example.spring04.repository.MapRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MapService {

	private final MapRepository mapRepository;
	
	public List<Map> read() {
		log.info("read()");
		List<Map> list = mapRepository.findAll();
		log.info("service=" + list.size());
		log.info("service=" + list);
		return list;
	}
	
}
