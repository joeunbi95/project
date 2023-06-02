package repository;

import java.util.List;

import domain.ProductVO;

public interface DAO {

	int insert(ProductVO ins);

	List<ProductVO> selectList();

	ProductVO detail(int pno);

	int edit(ProductVO pno);

	int remove(int pno);

}
