package com.yedam;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletContextTest1")
public class ServletContextTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletContextTest1() {
        super();
        
    }
    //ServletContext 생성 - Servlet 생성자 -> ServletConfig -> init() -> service()
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	ServletContext sc = config.getServletContext();//서블릿콘텍스트객체를 반환해준다
    	sc.setAttribute("servletContext", "Hello");//만들어지는 서블릿 객체에다가 값담기
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
