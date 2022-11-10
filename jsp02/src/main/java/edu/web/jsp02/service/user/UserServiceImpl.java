package edu.web.jsp02.service.user;

import java.util.List;

import edu.web.jsp02.domain.user.User;
import edu.web.jsp02.dto.user.UserCreateDto;
import edu.web.jsp02.dto.user.UserUpdateDto;
import edu.web.jsp02.repository.user.UserDao;
import edu.web.jsp02.repository.user.UserDaoImpl;
import edu.web.jsp02.service.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	// Singleton
	private static UserServiceImpl instance = null;
	
	private UserServiceImpl() {
		userDao = UserDaoImpl.getInstance();
	}
	
	public static UserServiceImpl getInstace() {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<User> read() {
		log.info("read()");
		return userDao.select();
	}

	@Override
	public int create(UserCreateDto dto) {
		log.info("create(dto={}", dto);
		return userDao.insert(dto.toEntity());
	}
	
	@Override
	public User read(Integer id) {
		log.info("read(id = {})", id);
		return userDao.selectById(id);
	}
	
	@Override
	public int update(UserUpdateDto dto) {
		log.info("update(dto={}", dto);
		return userDao.update(dto.toEntity());
	}

	@Override
	public int delete(Integer id) {
		log.info("delete(id = {})", id);
		return userDao.delete(id);
	}
}
