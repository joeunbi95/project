package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.MemberVO;
import domain.PagingVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {

	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	private SqlSession sql;
	private String NS = "Boardmapper.";
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	
	@Override
	public int insert(BoardVO bvo) {
		int isOk = sql.insert(NS+"insert", bvo);
		if(isOk > 0) {
			log.info("DB저장 완료");
			sql.commit();
		}
		return isOk;
	}


	@Override
	public List<BoardVO> selectList() {
		log.info(">>> list DAO 진입.");
		return sql.selectList(NS+"list");
	}


	@Override
	public BoardVO detail(int bno) {
		log.info(">>> detail DAO 진입.");
		return sql.selectOne(NS+"detail",bno);
	}


	@Override
	public int edti(BoardVO bvo) {
		log.info(">>> edit DAO 진입.");
		int isOk = sql.update(NS+"edit", bvo);
		if(isOk > 0) {
			log.info("DB저장 완료");
			sql.commit();
		}
		return isOk;
	}


	@Override
	public int delete(int bno) {
		log.info(">>> delete DAO 진입.");
		int isOk = sql.update(NS+"delete", bno);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}


	@Override
	public int updateCount(int bno) {
		int isOk = sql.update(NS+"count", bno);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int totCount(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return sql.selectOne(NS+"cnt", pgvo);
	}

	@Override
	public List<BoardVO> pageList(PagingVO pgvo) {
//		// TODO Auto-generated method stub
//		return sql.selectList(NS+"pageList", pgvo);
		return sql.selectList(NS+"selectList",pgvo);
	}


	@Override
	public List<BoardVO> mypage(String writer) {
		log.info(">>> mypage DAO 진입");
		return sql.selectList(NS+"mypage",writer);
	}


}
