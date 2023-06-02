package repository;


import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO selectOne(MemberVO mvo1);

	int lastLogin(String id2);

	int edit(MemberVO mvom);

	int remove(String idr);

	List<MemberVO> selectList();

}
