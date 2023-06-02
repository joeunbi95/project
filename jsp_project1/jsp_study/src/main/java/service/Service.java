package service;

import java.util.List;

import domain.ProductVO;

public interface Service {

	int register(ProductVO ins);

	List<ProductVO> list();

	ProductVO detail(int pno);

	int edit(ProductVO pno);

	int remove(int pno);

}
