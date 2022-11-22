package com.example.spring03.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.spring03.domain.Post;
import com.example.spring03.dto.PostCreateDto;
import com.example.spring03.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 초기화하는 생성자.
@Service // 스프링 컨텍스트에 Service 컴포넌트로 등록.
public class PostService {
	
	private final PostRepository postRepository; // 생성자에 의한 의존성 주입.
	
	public List<Post> read() {
		log.info("read()");
		return postRepository.findByOrderByIdDesc();
	}

	public Post create(PostCreateDto dto) {
		log.info("create(dto={})", dto);
		return postRepository.save(dto.toEntity());
	}
}
