package repository;

import java.util.List;

import domain.BoardVO;
import domain.MemberVO;
import domain.PagingVO;

public interface BoardDAO {

	int totCount(PagingVO pgvo);

	int insert(BoardVO bvo);

	List<BoardVO> selectList();

	BoardVO detail(int bno);

	int edti(BoardVO bvo);

	int delete(int bno);

	int updateCount(int bno);

	List<BoardVO> pageList(PagingVO pgvo);

	List<BoardVO> mypage(String writer);

}
