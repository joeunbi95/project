package service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {

	private static final Logger log = LoggerFactory.getLogger(MemberService.class);
	private MemberDAO mdao;
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}
	
	@Override
	public int register(MemberVO mvo) {
		log.info(">>> register service 진입.");
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO login(MemberVO mvo1) {
		log.info(">>> login service 진입.");
		return mdao.selectOne(mvo1);
	}

	@Override
	public int lastLogin(String id2) {
		log.info(">>> logout service 진입.");
		return mdao.lastLogin(id2);
	}

	@Override
	public int edit(MemberVO mvom) {
		log.info(">>> edit service 진입.");		
		return mdao.edit(mvom);
	}

	@Override
	public int remove(String idr) {
		log.info(">>> remove service 진입.");
		return mdao.remove(idr);
	}

	@Override
	public List<MemberVO> getlist() {
		log.info(">>> list service 진입.");
		return mdao.selectList();
	}


}
