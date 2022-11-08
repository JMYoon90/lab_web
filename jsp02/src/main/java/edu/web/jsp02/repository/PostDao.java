package edu.web.jsp02.repository;

import java.util.List;

import edu.web.jsp02.domain.Post;

public interface PostDao {

	public List<Post> select();
	public Post selectById(Integer id);
	public int insert(Post entity);
	public int delete(Integer id);
	public int update(Integer id, String title, String content);
}
