package edu.web.jsp02.service.user;

import java.util.List;

import edu.web.jsp02.domain.user.User;
import edu.web.jsp02.dto.user.UserCreateDto;
import edu.web.jsp02.dto.user.UserUpdateDto;

public interface UserService {

	public List<User> read();

	public int create(UserCreateDto dto);

	public User read(Integer id);

	public int update(UserUpdateDto dto);

	public int delete(Integer id);

	public User singIn(String username, String password);
}
