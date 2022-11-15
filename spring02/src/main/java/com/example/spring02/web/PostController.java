package com.example.spring02.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.spring02.domain.Post;
import com.example.spring02.dto.PostCreateDto;
import com.example.spring02.dto.PostUpdateDto;
import com.example.spring02.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller // 스프링 컨테이너가 Bean으로 생성, 관리
public class PostController {
	
	private final PostService postService; // 생성자에 의한 의존성 주입
	
	@GetMapping("/post/list")
	public String list(Model model) {
		log.info("list()");
		List<Post> list = postService.read();
		model.addAttribute("posts", list);
		
		return "/post/list";
	}
	
	@GetMapping("/post/create")
	public String create() {
		log.info("create()");
		
		return "/post/create";
	}
	
	@PostMapping("/postCreate")
	public String postCreate(String title, String content, String author) {
		log.info("create(title={},content={},author={}", title, content, author);
		PostCreateDto dto = PostCreateDto.builder()
				.title(title).content(content).author(author)
				.build();
		postService.insert(dto.toEntity());
		return "redirect:/post/list";
	}
	
	@GetMapping("/post/detail")
	public String detail(int id, Model model) {
		Post post = postService.selectById(id);
		model.addAttribute("post", post);
		log.info("detail()");
		return "/post/detail";
	}
	
	@GetMapping("/post/modify")
	public String modify(int id, Model model) {
		Post post = postService.selectById(id);
		model.addAttribute("post", post);
		log.info("detail()");
		return "/post/modify";
	}
	
	@PostMapping("/postUpdate")
	public String postUpdate(Integer id, String title, String content) {
		log.info("update(id={},title={},content={})", id, title, content);
		PostUpdateDto dto = PostUpdateDto.builder()
				.id(id).title(title).content(content)
				.build();
		postService.updateById(dto.toEntity());
		return "redirect:/post/list";
	}
	
	@PostMapping("/postDelete")
	public String postDelete(Integer id) {
		log.info("delete(id=}{)", id);
		postService.delete(id);
		return "redirect:/post/list";
	}
	

}
