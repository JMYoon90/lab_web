package edu.web.jsp02.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariDataSource;

import edu.web.jsp02.datasource.HikariDataSourceUtil;
import edu.web.jsp02.domain.Post;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

// MVC 아키텍쳐에서 Controller의 계층들 중에서 DB 관련 작업을 수행하는 계층.
// Controller 계층: Web layer(servlet) - Service layer - Repository layer(DAO)
@Slf4j
public class PostDaoImpl implements PostDao {
	// Slf4j 로그를 사용하기 위해서
	// private static final Logger log = LoggerFactory.getLogger(PostDaoImpl.class);
	
	// Singleton
	private static PostDaoImpl instance = null;
	
	private HikariDataSource ds;
	
	private PostDaoImpl() {
		ds = HikariDataSourceUtil.getIstance().getDataSource();
	}
	
	public static PostDaoImpl getInstance() {
		if (instance == null) {
			instance = new PostDaoImpl();
		}
		return instance;
	}
	
	public static final String SQL_SELECT = "select * from POSTS order by ID desc";

	@Override
	public List<Post> select() {
		log.info("select()");
		log.info("SQL: {}", SQL_SELECT);
		
		List<Post> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection(); // Connection Pool(Data Source)에서 Connection을 빌려옴.
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			
			while ( rs.next()) { // select 결과에서 row 데이터가 있으면
				Integer id = rs.getInt("id");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String author = rs.getString("AUTHOR");
				LocalDateTime createdTime = rs.getTimestamp("CREATED_TIME").toLocalDateTime();
				LocalDateTime modifiedTime = rs.getTimestamp("MODIFIED_TIME").toLocalDateTime();
				
				Post post = Post.builder()
						.id(id).title(title).content(content).author(author)
						.createdTime(createdTime).modifiedTime(modifiedTime)
						.build();
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close(); // Data Source에서 빌려온 Connection을 반환.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public static final String SQL_INSERT = 
			"insert into POSTS (TITLE, CONTENT, AUTHOR, CREATED_TIME, MODIFIED_TIME)"
			+ "values (?, ?, ?, sysdate, sysdate)";

	@Override
	public int insert(Post entity) {
		log.info("insert(entity={}", entity);
		log.info(SQL_INSERT);
		int result = 0; // DB에 insert 성공하면 1, 실패하면 0
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, entity.getTitle());
			stmt.setString(2, entity.getContent());
			stmt.setString(3, entity.getAuthor());
			
			result = stmt.executeUpdate(); // insert된 행의 개수를 리턴.
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		return result;
	}
	
	public static final String SQL_SELECT_BY_ID = 
			"select * from POSTS where ID = ?";

	@Override
	public Post selectById(Integer id) {
		log.info("selectById(id = {})", id);
		
		// 엔터티: DB 테이블의 행에 저장된 데이터. 레코드.
		Post entity = null;
		
		try {
			@Cleanup // 리소스 사용이 끝난 후에 close() 메서드를 자동으로 호출.
			Connection conn = ds.getConnection();
			
			@Cleanup
			PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			log.info(SQL_SELECT_BY_ID);
			
			stmt.setInt(1, id);
			
			@Cleanup
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) { // 검색된 행(row, 레코드)가 있으면
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String author = rs.getString("AUTHOR");
				LocalDateTime createdTime = rs.getTimestamp("CREATED_TIME").toLocalDateTime();
				LocalDateTime modifiedTime = rs.getTimestamp("MODIFIED_TIME").toLocalDateTime();
				
				entity = Post.builder()
						.id(id).title(title).content(content).author(author)
						.createdTime(createdTime).modifiedTime(modifiedTime)
						.build();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Connection, PreparedStatement, ResultSet을 선언할 때 @Cleanup을 사용했기 때문에,
		// finally에서 close 메서드를 호출할 필요 없이, 모든 리소스는 자동으로 해제됨.
		return entity;
	}
	
	public static final String SQL_DELETE = 
			"delete from POSTS where ID = ?";
	
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
	
	public static final String SQL_UPDATE = 
			"update POSTS set TITLE = ?, CONTENT = ?, MODIFIED_TIME = sysdate where ID = ?";

	@Override
	public int update(Integer id, String title, String content) {
		int result = 0;
		
		try {
			@Cleanup
			Connection conn = ds.getConnection();
			
			@Cleanup
			PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
			
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setInt(3, id);
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
