package service;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardService {

	int insert(BoardVO bvo);

	List<BoardVO> getlist();

	BoardVO detail(int bno);

	int edit(BoardVO bvo);

	int remove(int bno);

	int getTotal(PagingVO pgvo);

	List<BoardVO> getPageList(PagingVO pgvo);

	


}
