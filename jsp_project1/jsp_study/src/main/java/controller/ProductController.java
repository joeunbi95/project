package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProductVO;
import service.ProductService;
import service.Service;


public class ProductController extends HttpServlet { 
	
	private static final long serialVersionUID = 1L;
    // 상품등록, 상품리스트, 상품상세, 상품수정, 상품삭제
	// 1. Controller -> service 
	// 2. service -> DAO 
	// 3. DAO -> DBconnection 
	
	private Service svc;
	
	
	/* 생성자 */
    public ProductController() { 
    	svc = new ProductService();
    }
    
	
    /* 주 작업 영역 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get / post 모든 처리는 service에서 처리함.
		
		/* post 방식으로 데이터 처리를 할 때 한글이 깨지는 것을 방지 */
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		/* ------------------------------------------- */
		
		String uri = req.getRequestURI();  /* .pd 요청 경로(원하는 서비스) 컨트롤러주소/요청서비스 */
		System.out.println("uri.log >>"+uri);  /* 나만의 로그 남기기 */
		String context = req.getContextPath();  //프로젝트 명
		System.out.println("context >>");
		
		// 객체를 보내야하는 목적지 주소
		String destPage = "";
		
		// 오는 요청에 대한 처리
		switch(uri) { 			

			case "/register.pd":	
				/* /폴더명/jsp파일명.jsp */	
				destPage="/register.jsp";
				break;
				
			
			/* 상품 등록 페이지 */
			case "/insert.pd" :
				// DB연결, 등록처리
				// jsp에서 가져온 객체(이름, 가격, 상세설명)를 가지고 와서 service에게 가져온 데이터를 객체화 하여 DB에 저장 요청
				
				/* 1. 객체를 생성. */
				String pname = req.getParameter("pname");
				int price = Integer.parseInt(req.getParameter("price")); //String 처리
				String madeby = req.getParameter("madeby");
				ProductVO ins = new ProductVO(pname, price, madeby);
				
				// 생성자가 없을경우(생성자를 만들어주는것이 좋음.)
				// ProductVO pvo = new ProductVO();
				// pvo.setPname(pname);
				// pvo.setPrice(price);
				// pvo.setMadeby(madeby);
				
				/* 2. service에게 객체 전달 요청 */
				int isOk = svc.register(ins); // 리턴값 1개의 행이 등록
				System.out.println("상품등록 : "+(isOk > 0 ? "성공" : "실패"));				
				destPage="/index.jsp";
				
				break;
				
				
			/* 상품 리스트 페이지*/	
			case "/list.pd" :
				List<ProductVO> list = new  ArrayList<ProductVO>();
				
				list = svc.list();
				req.setAttribute("list", list);
				System.out.println(">>> 상품 리스트 성공.");
				destPage="/list.jsp";
				
				break;
			
				
			/* 상품 상세 페이지 */	
			case "/detail.pd" :
				int pno = Integer.parseInt(req.getParameter("pno"));
				ProductVO p = new ProductVO();
				p = svc.detail(pno);
				req.setAttribute("pvo", p);
				System.out.println(">>> 상품 상세페이지 성공.");
				destPage="/detail.jsp";
				
				break;
				
				
			/* 상품 수정 페이지 */
			case "/modify.pd" :
				int pnom = Integer.parseInt(req.getParameter("pno"));
				req.setAttribute("pvo",svc.detail(pnom));
				System.out.println(">>> 상품 수정페이지 성공.");
				destPage="/modify.jsp";
				
				break;
				
				
			/* 상품 수정 작업 */
			case "/edit.pd" :
				int pnoe = Integer.parseInt(req.getParameter("pno"));
				String pnamem = req.getParameter("pname");
				int pricem = Integer.parseInt(req.getParameter("price")); //String 처리
				String madebym = req.getParameter("madeby");
				ProductVO edit = new ProductVO(pnoe, pnamem, pricem, madebym);
				
				int isOkm = svc.edit(edit); // 리턴값 1개의 행이 등록
				System.out.println("상품수정 : "+(isOkm > 0 ? "성공" : "실패"));
				destPage="/list.pd";
				
				break;
				
				
			/* 상품 삭제 작업 */
			case "/remove.pd":
				int pnor = Integer.parseInt(req.getParameter("pno"));
				
				int isOkr = svc.remove(pnor);
				System.out.println("상품삭제 : "+(isOkr > 0 ? "성공" : "실패"));
				
				break;
				
		}
		
		// 웹의 목적지 주소로 연결해주는 객체
		// destPage로 이동시 응답(요청) 객체를 싣고 가야 함.
		RequestDispatcher rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
		
		
		
	}
	
	
	/* get 방식으로 오는 값을 체킹 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		service(req, res); //get과 post를 분리하지않고 쉽게하기 위한 방식  /* service */
	}
	
	
	/* post 방식으로 오는 값을 체킹*/
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		service(req, res); //get과 post를 분리하지않고 쉽게하기 위한 방식  /* service */
	}

}
