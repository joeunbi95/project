package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import orm.DatabaseBuilder;

public class CommentDAOImpl implements CommentDAO {
	
	private static final Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
	private SqlSession sql;
	private String NS = "Commentmapper.";
	private int isOk;
	
	public CommentDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	@Override
	public int post(CommentVO cvo) {
		log.info(">>> post DAO 진입");
		isOk = sql.insert(NS+"reg", cvo);
		if(isOk>0) {
			log.info("DB저장완료");
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<CommentVO> getlist(int bno) {
		log.info(">>> List DAO 진입");
		return sql.selectList(NS+"list",bno);
	}

	@Override
	public int delete(int cno) {
		log.info(">>> remove DAO 진입");
		isOk = sql.delete(NS+"rmv", cno);
		if(isOk > 0) {
			log.info("DB삭제완료");
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int update(CommentVO cvo) {
		log.info(">>> update DAO 진입");
		isOk = sql.update(NS+"up",cvo);
		if(isOk>0) {
			log.info("DB수정완료");
			sql.commit();
		}
		return isOk;
	}

}
