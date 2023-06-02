package repository;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	// NameSpace = SQL이 mapper를 구분하기 위한 이름
	// NameSpace.SQL구문이름
	private String NS = "Membermapper.";
	
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(MemberVO mvo) {
		/* sql.insert(NS+이름, 객체); */
		//transaction 처리가 자동으로 이루어짐.
		int isOk = sql.insert(NS+"reg", mvo);
		if(isOk > 0) {
			log.info("DB저장 완료");
			sql.commit();
		}
		return isOk;
	}

	@Override
	public MemberVO selectOne(MemberVO mvo1) {
		log.info("login DAO 진입.");
		return sql.selectOne(NS+"login", mvo1);
	}

	@Override
	public int lastLogin(String id2) {
		log.info("logout DAO 진입.");
		int isOk = sql.update(NS+"logout", id2);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int edit(MemberVO mvom) {
		log.info("edit DAO 진입.");
		int isOk = sql.update(NS+"edit", mvom);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}


	@Override
	public int remove(String idr) {
		log.info("remove DAO 진입.");
		int isOk = sql.delete(NS+"remove", idr);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<MemberVO> selectList() {
		log.info("list DAO 진입.");		
		return sql.selectList(NS+"list");
	}

}
