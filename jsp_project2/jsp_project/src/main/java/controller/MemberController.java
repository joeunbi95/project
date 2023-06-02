package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberServiceImpl;
import service.MemberService;


@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/* log설정 */ 
	// private static final Logger log = LoggerFactory.getLogger(클래스명);    
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private RequestDispatcher rdp;
	private MemberService msv;
	private int isOk;
	private String destPage; //목적지 주소
	
 
    public MemberController() {
        msv = new MemberServiceImpl();        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// characterEncoding 설정 /contentType / uri
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String uri = request.getRequestURI();
		log.info(">>> uri : " +uri);
		// /mem/join : 요청에 대한 path만 남기기
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(">>> path : " +path);
		
		switch (path) {
		case "join":
			destPage = "/member/join.jsp";
			break;

		case "register":
			// jsp 에서 가져온 파라미터 저장
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			int age = Integer.parseInt(request.getParameter("age"));
			
			// 파라미터로 mvo 객체 생성
			MemberVO mvo = new MemberVO(id, password, email, age);
			isOk = msv.register(mvo);
			log.info(">>> JOIN > " + (isOk>0 ? "성공" : "실패"));
			destPage="/"; /* "/" => 기본페이지 */
			break;
			
		case "login" : /* 로그인 페이지로 이동 케이스*/
			log.info(">>> login page 이동");
			destPage="/member/login.jsp";
			break;
			
		case "login_auth" : /* 실제 로그인이 일어나는 케이스*/
			try {
				String id1 = request.getParameter("id");
				String pw1 = request.getParameter("password");
				MemberVO mvo1 = new MemberVO(id1, pw1);
				// 해당 id, password가 DB상에 있는지 체크
				// 해당 객체(사용자)를 가져온후
				// 해당 객체(사용자)를 세션에 담기
				log.info(">>> login 요청"+ mvo1);
				MemberVO loginMvo = msv.login(mvo1);
				// 같은정보가 있으면 객체를 리턴, 없다면 null이 리턴
				// 객체가 있다면 세션에 저장
				if(loginMvo != null) {
					// 세션 가져오기. 연결된 세션이 없다면 새로 생성
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", loginMvo);
					// 로그인 유지 시간(초단위) 
					ses.setMaxInactiveInterval(10*60);
				}else {
					request.setAttribute("msg_login", 0);
				}
				
				destPage="/";
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
			
		case "logout" :
			try {
				// 세션 가져오기 (연결된 세션)
				HttpSession ses = request.getSession();
				// 마지막 로그인 시간 기록
				MemberVO mvo2 = (MemberVO)ses.getAttribute("ses");
				String id2 = mvo2.getId();
				log.info(">>>> login id : "+id2);
				// 로그인 정보(id)를 주고 마지막 로그인 시간 기록(update)
				isOk = msv.lastLogin(id2);
				log.info(">>> logout > " +(isOk>0? "성공" : "실패"));
				ses.invalidate(); /* 세션 초기화 */
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			destPage="/";
			break;
			
		case "modify" :			
			destPage="/member/modify.jsp";
			break;
			
		case "edit" :
			try {
				String idm = request.getParameter("id");				
				String pwm = request.getParameter("password");
				String emm = request.getParameter("email");
				int agm = Integer.parseInt(request.getParameter("age"));
				String reg = request.getParameter("reg_date");
				String last = request.getParameter("last_login");
				MemberVO mvom = new MemberVO(idm, pwm, emm, agm, reg, last);
				isOk = msv.edit(mvom);
				log.info(">>> Update > " + (isOk>0 ? "성공" : "실패"));
				destPage="/";
				
				if(isOk > 0 ){
					//case 1 session 객체에 값을 담기
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", mvom);
					
					//case 2 login_auth case로 mvo3 객체 보내기
					// request.setAttribute("mvo", mvom);
				}
				// destPage="login_auth";
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
			
		case "remove" :
			try {
				HttpSession ses = request.getSession();
				MemberVO mvor = (MemberVO)ses.getAttribute("ses");
				String idr = mvor.getId();
				
				mvor.getId();
				isOk = msv.remove(idr);
				log.info(">>> remove " +(isOk>0 ? "완료" : "실패"));
				ses.invalidate(); /* 세션 초기화 */
				destPage="/";
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
			
		case "list" :
			try {
				List<MemberVO> list = new ArrayList<MemberVO>();	
				list = msv.getlist();								
				request.setAttribute("list", list);					
				log.info(">>> list page 이동.");
				destPage= "/member/list.jsp";
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
		}
		
		RequestDispatcher rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
