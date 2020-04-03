package kr.co.stephen.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.stephen.board.model.BoardDAO;
import kr.co.stephen.board.model.BoardVO;
import kr.co.stephen.board.service.ContentServiceImpl;
import kr.co.stephen.board.service.GetListServiceImpl;
import kr.co.stephen.board.service.IBoardService;
import kr.co.stephen.board.service.ModifyServiceImpl;
import kr.co.stephen.board.service.RegistServiceImpl;
import kr.co.stephen.board.service.UpdateServiceImpl;

@WebServlet("*.board") //확장자 패턴.
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	IBoardService sv;
	RequestDispatcher dp;

    public BoardController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		uri = uri.substring(conPath.length()+1, uri.lastIndexOf("."));
		System.out.println(uri);
		
		switch(uri) {
		
		case "write":
			System.out.println("글 작성 페이지 이동 요청!");
			response.sendRedirect("/MyWeb/board/board_write.jsp");
			break;
			
		case "regist":
			System.out.println("글 등록 요청이 들어옴!");
			sv = new RegistServiceImpl();
			sv.execute(request, response);
			
			response.sendRedirect("/MyWeb/list.board");
			break;
			
		case "list":
			System.out.println("글 목록 요청이 들어옴!");
			sv = new GetListServiceImpl();
			sv.execute(request, response);
			 
			//request객체를 다음 화면까지 운반하기 위한 forward 이동을 지원하는 객체
			//-> RequestDispatcher
			dp = request.getRequestDispatcher("/board/board_list.jsp");
			dp.forward(request, response);
			break;
			
		case "content":
			System.out.println("글 상세보기 요청이 들어옴!");
			sv = new ContentServiceImpl(); 
			sv.execute(request, response);
			
			dp = request.getRequestDispatcher("/board/board_content.jsp");
			dp.forward(request, response);
			break;
			
		case "modify":
			System.out.println("글 수정 페이지로 이동 요청!");
			sv = new ModifyServiceImpl();
			sv.execute(request, response);
			
			dp = request.getRequestDispatcher("/board/board_modify.jsp");
			dp.forward(request, response);
			break;
			
		case "update":
			System.out.println("글 수정 요청이 들어옴!");
			sv = new UpdateServiceImpl();
			sv.execute(request, response);
			//updateBoard()완성시킨 후 service클래스에서 메서드 호출
			//list.board로 컨트롤러한테 재요청.
			
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
