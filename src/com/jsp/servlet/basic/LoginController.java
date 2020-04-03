package com.jsp.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.stephen.user.model.UserDAO;
import kr.co.stephen.user.model.UserVO;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		1. 파라미터값 얻어오기
		2. DAO 주소값 얻어오기
		3. 로그인 유효성 검증 메서드 userCheck 호출하기
		// 아이디가 없다면 스크립트로 경고창 출력 후 회원가입 페이지로 이동.
		// 비밀번호가 틀린 경우 비밀번호가 틀렸다고 경고창 출력 후 뒤로가기.
		// 로그인 성공인 경우 user_mypage.jsp로 리다이렉팅.
		// 이름과 id값으로 각각 세션 하나씩 생성 (user_name, user_id);
		*/
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.getInstance();
		
		int result = dao.userCheck(id, pw);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String htmlCode;
		
		if(result == -1) {
			htmlCode = "<script>\r\n" + "alert(\"비밀번호가 틀렸습니다.\");\r\n" 
					+ "history.back();\r\n"
					+ "</script>";
			out.println(htmlCode);
		} else {
			UserVO vo = dao.getUserInfo(id);
			
			session.setAttribute("user_name", vo.getName());
			session.setAttribute("user_id", id);
			response.sendRedirect("/MyWeb/user/user_mypage.jsp");
		}
		
		out.flush();
		out.close();
	}

}
