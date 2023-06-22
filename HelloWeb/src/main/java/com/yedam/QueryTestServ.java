package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryTestServ
 */
@WebServlet({ "/QueryTestServ", "/queryTest" })
public class QueryTestServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryTestServ() {
        super();
    }
    //service() 를 정의하지 않으면 
    
    // 요청방식에 따라 get 요청이면 doGet() 메소드를 호출하도록 톰캣컨테이너가 서블릿을 실행한다
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("Get방식 호출입니다");
		//param 전달 
		String id = request.getParameter("id"); //name 속성의 id값을 id라는 스트링변수에 담는다
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		String [] hobbies = request.getParameterValues("hobby");//반환하는 값이 많으면 values붙여주고 배열로 생성
		String gender = request.getParameter("gender");
		String religion = request.getParameter("religion");
		String intro = request.getParameter("intro");
		
		//응답정보.
		PrintWriter out = response.getWriter();//출력하는 스트림 - 사용ㅇ자화면으로 출력
		out.print("<p>ID: "+id+ "</p>");
		out.print("<p>비번: "+pwd+ "</p>");
		out.print("<p>이름: "+name+ "</p>");
		for(String hobby : hobbies) {
			out.print("<p>취미: "+hobby+ "</p>");
		}
		out.print("<p>성별: "+gender+ "</p>");
		out.print("<p>종교: "+religion+ "</p>");
		out.print("<p>자기소개: "+intro+ "</p>");
		
		out.print("<p>QueryString : "+ request.getQueryString()+"</p>");
		
	}
	//요청방식에따라 post요청이면 doPost()호출 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post방식 호출입니다");
		
		response.setContentType("text/html;charset=UTF-8");//한글처리
		request.setCharacterEncoding("UTF-8");
		
		Enumeration<String> enm = request.getHeaderNames();//커넥션정보 , 등등 보기위한 코드 (확인차쓴거)
		while(enm.hasMoreElements()) {
			String elem = enm.nextElement();
			System.out.println("header: "+elem+", val: "+ request.getHeader(elem));//헤더에 포함되어있는 키값 밸류값
		}
		
		//param 전달 
//				String id = request.getParameter("id"); //name 속성의 id값을 id라는 스트링변수에 담는다
//				String pwd = request.getParameter("pwd");
//				String name = request.getParameter("name");
//				
//				String [] hobbies = request.getParameterValues("hobby");//반환하는 값이 많으면 values붙여주고 배열로 생성
//				String gender = request.getParameter("gender");
//				String religion = request.getParameter("religion");
//				String intro = request.getParameter("intro");
				
				//응답정보.
				PrintWriter out = response.getWriter();//출력하는 스트림 - 사용ㅇ자화면으로 출력
//				out.print("<p>ID: "+id+ "</p>");
//				out.print("<p>비번: "+pwd+ "</p>");
//				out.print("<p>이름: "+name+ "</p>");
//				for(String hobby : hobbies) {
//					out.print("<p>취미: "+hobby+ "</p>");
//				}
//				out.print("<p>성별: "+gender+ "</p>");
//				out.print("<p>종교: "+religion+ "</p>");
//				out.print("<p>자기소개: "+intro+ "</p>");
//				
				
				
				
				ServletInputStream sis = request.getInputStream();//입력스트림을 받아줘야 post에서 쓸수있음
				int len = request.getContentLength();
				byte[] buf = new byte[len]; //
				sis.readLine(buf, 0, len); //읽어들인 buf,0부터 len까지 읽어들인다
				
				String queryString = new String(buf);
				out.print("<p>QueryString : "+ queryString+"</p>");//post에선 적용안됨)
			}
	}
	//get방식인지 post방식인지에따라ㅏ 다르다
	//get방식호출: 주소창에 정보가 다 나타난다  주로 조회하는방식
	//post방식 호출: 주소창에 아무런 정보도 없다.  보낼 데이터가 많을때 주소창이 길어지니까 post사용

