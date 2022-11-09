package edu.web.jsp02.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.user.User;
import edu.web.jsp02.service.PostService;
import edu.web.jsp02.service.user.UserService;
import edu.web.jsp02.service.user.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UserDetailController
 */
@Slf4j
@WebServlet(name = "userDetailController", urlPatterns = { "/users/detail" })
public class UserDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailController() {
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
		log.info("user = {}", user);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/users/detail.jsp")
			.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
