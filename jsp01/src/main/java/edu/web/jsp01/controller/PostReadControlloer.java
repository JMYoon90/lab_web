package edu.web.jsp01.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp01.domain.Post;

/**
 * Servlet implementation class postReadControlloer
 */
@WebServlet(name = "postReadController", urlPatterns = { "/post/read" })
public class PostReadControlloer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostReadControlloer() {
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("PostRegisterController.goGet() 호출");
		
		request.getRequestDispatcher("/WEB-INF/post/read.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    
		ArrayList<Post> list = new ArrayList<>();
	    for (int i = 0; i < 10; i++) {
	    	Post p = new Post(i, "제목" + i, "내용" + i, null);
	    	list.add(p);
	    }
	    request.setAttribute("post", list);
	    request.getRequestDispatcher("/WEB-INF/post/read.jsp")
	    	.forward(request, response);
	}

}
