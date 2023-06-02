package service;


import java.util.List;

import domain.MemberVO;

public interface MemberService {

	int register(MemberVO mvo);

	MemberVO login(MemberVO mvo1);

	int lastLogin(String id2);

	int edit(MemberVO mvom);

	int remove(String idr);

	List<MemberVO> getlist();


}
