package com.example.spring02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring02.domain.Post;
import com.example.spring02.dto.PostCreateDto;
import com.example.spring02.dto.PostSearchDto;
import com.example.spring02.dto.PostUpdateDto;
import com.example.spring02.mapper.PostMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 argument로 갖는 생성자를 만듦.
@Service
// -> @Service + applicationContext.xml : 스프링 컨테이너에 서비스 컴포넌트로 등록.
// -> 스프링 컨테이너가 필요한 곳(Ex: Controller Class)에 Service 컴포넌트를 주입할 수 있음.

public class PostService {
	
	// 의존성 주입(dependency inject):
	// (1) 필드에 의한 의존성 주입: @Autowired
	// (2) 생성자에 의한 의존성 주입: final 필드 + Required-Args 생성자
	// 생성자에 의한 의존성 주입
	
	// @Autowired private PostMapper postMapper; // (1)
	
	private final PostMapper postMapper; // (2)
	
	public List<Post> read() {
		log.info("read()");
		return postMapper.selectOrderByIdDesc();
	}
	
	public int insert(PostCreateDto dto) {
		log.info("insert(dto={})", dto);
		return postMapper.insert(dto.toEntity());
	}
	
	public Post selectById(Integer id) {
		log.info("read(id={})", id);
		return postMapper.selectById(id);
	}

	public int updateById(PostUpdateDto dto) {
		return postMapper.updateById(dto.toEntity());
	}
	
	public int delete(Integer id) {
		return postMapper.deleteById(id);
	}
	
	public List<Post> searchByKeyword(PostSearchDto dto) {
		log.info("search(dto= {})", dto);
		
		dto.setKeyword("%" + dto.getKeyword().toLowerCase()+ "%");
		
		return postMapper.selectByKeywordOderByIdDesc(dto);
	}
}
