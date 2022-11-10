package edu.web.jsp02.web.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.dto.user.UserCreateDto;
import edu.web.jsp02.service.user.UserService;
import edu.web.jsp02.service.user.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UserCreateController
 */
@Slf4j
@WebServlet(name = "userCreateController", urlPatterns = { "/users/create" })
public class UserCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateController() {
    	userService = UserServiceImpl.getInstace();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		log.info("doGet()");
		
		request.getRequestDispatcher("/WEB-INF/users/create.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		log.info("doPost()");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		UserCreateDto dto = UserCreateDto.builder()
				.username(username).password(password).email(email)
				.build();
		log.info("dto = {}", dto);
		
		int result = userService.create(dto);
		
		log.info("create result = {}", result);
		
		response.sendRedirect("/jsp02/users");
		
	}

}
