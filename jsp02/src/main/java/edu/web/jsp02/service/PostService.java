package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.dto.PostCreateDto;
import edu.web.jsp02.dto.PostUpdateDto;

public interface PostService {

	public List<Post> read(); // 포스트 전체 목록 읽어오기
	public int create(PostCreateDto dto); // 포스트 작성하기
	public Post read(Integer id); // id(포스트 번호)가 일치하는 포스트 읽어오기
	public int delete(Integer id); //id(포스트 번호)가 일치하는 포스트 삭제
	public int update(PostUpdateDto dto); 
	public List<Post> search(String type, String keyword);
}
