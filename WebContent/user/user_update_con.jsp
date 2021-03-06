<%@page import="kr.co.stephen.user.model.UserVO"%>
<%@page import="kr.co.stephen.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/*
		1. 폼 데이터를 처리하세요.
		2. DAO 연동을 통해 updateUser()라는 메서드를 호출하여 회원정보를 수정합니다.
		 회원 정보 수정을 성공했다면 이름에 대한 세션도 다시 제작해 주셔야 합니다.
		3. 수정 성공시 "회원정보가 수정되었습니다." 를 스크립트로 출력 후 마이페이지로 이동.
		4. 수정 실패시 "회원정보 수정에 실패했습니다." 출력 후 마이페이지로 이동.
	*/
	
	request.setCharacterEncoding("utf-8");

	UserVO vo = new UserVO();
	
	vo.setId(request.getParameter("id"));
	vo.setName(request.getParameter("name"));
	vo.setEmail(request.getParameter("email"));
	vo.setAddress(request.getParameter("address"));
	
	if(UserDAO.getInstance().updateUser(vo)) {
		
		//이름정보를 변경했으니 세션도 다시 제작.
		 %>
		
		<script>
			alert("회원 정보가 수정되었습니다.");
			setTimeout(location.href="user_mypage.jsp", 30000);
			
		</script>	
	<% 
	session.setAttribute("user_name", request.getParameter("name"));
	} else { %>
		<script>
			alert("회원 정보 수정에 실패했습니다.");
			location.href="user_mypage.jsp";
		</script>
	
	<% } %>
	
	
	

















