package edu.web.jsp02.web.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.service.user.UserService;
import edu.web.jsp02.service.user.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UserDeleteController
 */
@Slf4j
@WebServlet(name = "userDeleteController", urlPatterns = { "/users/delete" })
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteController() {
    	userService = UserServiceImpl.getInstace();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		log.info("doPost()");
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		log.info("id={}", id);
		
		int result = userService.delete(id);
		log.info("delete result = {}", result);
		
		response.sendRedirect("/jsp02/users");
	}

}
