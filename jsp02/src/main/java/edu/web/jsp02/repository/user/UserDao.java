package edu.web.jsp02.repository.user;

import java.util.List;

import edu.web.jsp02.domain.user.User;

public interface UserDao {
	
	public List<User> select();

	public int insert(User entity);

	public User selectById(Integer id);

}
