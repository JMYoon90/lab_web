package edu.web.jsp02.repository.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zaxxer.hikari.HikariDataSource;

import edu.web.jsp02.datasource.HikariDataSourceUtil;
import edu.web.jsp02.domain.user.User;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDaoImpl implements UserDao {

	// Singleton
	private static UserDaoImpl instance = null;
	
	private HikariDataSource ds;
	
	private UserDaoImpl() {
		ds = HikariDataSourceUtil.getIstance().getDataSource();
	}
	
	public static UserDaoImpl getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	private User recordToentity(ResultSet rs) throws SQLException {
		Integer id = rs.getInt("ID");
		String username = rs.getString("USERNAME");
		String password = rs.getString("PASSWORD");
		String email = rs.getString("EMAIL");
		Integer points = rs.getInt("POINTS");
		
		User entity = User.builder()
				.id(id).username(username).password(password)
				.email(email).points(points)
				.build();
		
		return entity;
	}
	
	public static final String SQL_SELECT =
			"select * from USERS order by ID desc";
	
	@Override
	public List<User> select() {
		log.info("select()");
		log.info("SQL: {}", SQL_SELECT);
		
		List<User> list = new ArrayList<>();
		
		try {
			@Cleanup
			Connection conn = ds.getConnection();
			@Cleanup
			PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
			@Cleanup
			ResultSet rs = stmt.executeQuery();
			
			while ( rs.next()) {
				User user = recordToentity(rs);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static final String SQL_INSERT = 
			"insert into USERS (USERNAME, PASSWORD, EMAIL) values (?, ?, ?)";
	
	@Override
	public int insert(User entity) {
		log.info("insert(entity={}", entity);
		log.info(SQL_INSERT);
		int result = 0;
		
		try {
			@Cleanup
			Connection conn = ds.getConnection();
			@Cleanup
			PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, entity.getUsername());
			stmt.setString(2, entity.getPassword());
			stmt.setString(3, entity.getEmail());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static final String SQL_SELECT_BY_ID = 
			"select * from USERS where ID = ?";
	
	@Override
	public User selectById(Integer id) {
		log.info("selectById(id = {})", id);
		
		User entity = null;
		
		try {
			@Cleanup
			Connection conn = ds.getConnection();
			
			@Cleanup
			PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			log.info(SQL_SELECT_BY_ID);
			
			stmt.setInt(1, id);
			
			@Cleanup
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				entity = recordToentity(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return entity;
	}
	public static final String SQL_UPDATE = 
			"update USERS set PASSWORD = ?, EMAIL = ? where ID = ?";
	
	@Override
	public int update(User entity) {
		int result = 0;
		
		try {
			
			Connection conn = ds.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
			
			stmt.setString(1, entity.getPassword());
			stmt.setString(2, entity.getEmail());
			stmt.setInt(3, entity.getId());
			
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static final String SQL_DELETE = 
			"delete from USERS where ID = ?";
	@Override
	public int delete(Integer id) {
		
		log.info("delete(id = {})", id);
		
		int result = 0; // DB에서 delete SQL 실행 결과값을 저장하기 위한 변수
		
		try {
			@Cleanup
			Connection conn = ds.getConnection();
			
			@Cleanup
			PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);
			
			stmt.setInt(1, id);
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
