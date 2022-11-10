package edu.web.jsp02.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.user.User;
import edu.web.jsp02.dto.PostUpdateDto;
import edu.web.jsp02.dto.user.UserUpdateDto;
import edu.web.jsp02.service.user.UserService;
import edu.web.jsp02.service.user.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UserModifyController
 */
@Slf4j
@WebServlet(name = "userModifyController", urlPatterns = { "/users/modify" })
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifyController() {
    	userService = UserServiceImpl.getInstace();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		log.info("doGet()");
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		log.info("id = {}", id);
		
		User user = userService.read(id);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/users/modify.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		log.info("doPost()");
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		String password = request.getParameter("password1");
		String email = request.getParameter("email");
		
		UserUpdateDto dto = UserUpdateDto.builder()
				.id(id).password(password).email(email)
				.build();
		
		int result = userService.update(dto);
		
		response.sendRedirect("/jsp02/users");
				
	}

}
