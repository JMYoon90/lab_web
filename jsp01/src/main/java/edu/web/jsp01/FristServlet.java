package edu.web.jsp01;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FristServlet
 */
@WebServlet(name = "fristServlet", urlPatterns = { "/ex1" })
//-> 처리하는 요청 주소(request URL)와 서블릿 객체 이름을 WAS(Web Application Server - Tomcat)에 등록.
public class FristServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FristServlet() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    //-> GET 방식의 요청일 때 WAS(Tomcat)가 호출하는 메서드.
    //-> 파라미터 request: 클라이언트(브라우저)가 보낸 요청(request)에 대한 정보를 가지고 있는 객체.
    //-> 파라미터 response: WAS가 클라이언트로 보낼 응답(response)을 작성하기 위한 기능들을 가지고 있는 객체.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 응답의 한글이 깨지지 않도록 하기 위해서.
    	// 반드시 response.gerWriter() 메서드를 호출하기 전에 사용해야 함.
    	response.setContentType("text/html; charset=UTF-8");
    	
    	LocalDateTime now = LocalDateTime.now(); // WAS의 현재 시간
    	
    	PrintWriter writer = response.getWriter(); // 응답을 write할 수 있는 객체.
    	// 응답으로 보낼 HTML 코드들을 작성.
    	writer.append("<!doctype html>")
    		.append("<html>")
    		.append("    <head>")
    		.append("        <meta charset='UTF-8'>")
    		.append("        <title>Servlet</title>")
    		.append("    </head>")
    		.append("    <body>")
    		.append("        <h1>첫번째 Servlet</h1>")
    		.append("        <h2>")
    		.append(now.toString())
    		.append("        </h2>")
    		.append("    </body>")
    		.append("</html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    //-> POST 방식의 요청일 때 WAS가 호출하는 메서드.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
