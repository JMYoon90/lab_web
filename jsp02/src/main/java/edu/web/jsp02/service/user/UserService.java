package edu.web.jsp02.service.user;

import java.util.List;

import edu.web.jsp02.domain.user.User;
import edu.web.jsp02.dto.user.UserCreateDto;

public interface UserService {

	public List<User> read();

	public int create(UserCreateDto dto);

	public User read(Integer id);
}