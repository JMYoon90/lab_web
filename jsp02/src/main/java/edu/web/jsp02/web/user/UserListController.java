package edu.web.jsp02.web.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.user.User;
import edu.web.jsp02.service.user.UserService;
import edu.web.jsp02.service.user.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UserListController
 */
@Slf4j
@WebServlet(name = "userListController", urlPatterns = { "/users" })
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListController() {
    	userService = UserServiceImpl.getInstace();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		log.info("doGet()");
		
		List<User> list = userService.read();
		log.info("# of list = {}", list.size());
		
		request.setAttribute("users", list);
		request.getRequestDispatcher("WEB-INF/users/list.jsp")
			.forward(request, response);
	}


}
