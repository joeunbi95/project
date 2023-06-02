package service;

import java.util.List;

import domain.ProductVO;
import repository.DAO;
import repository.ProductDAO;

public class ProductService implements Service {
	
	private DAO dao;
	
	public ProductService() {
		dao = new ProductDAO();
	}
	
	@Override
	public int register(ProductVO ins) {
		// jsp에서 받은 객체 pvo를 가지고 dao에게 db 삽입 요청
		// dao에게 연결할 매서드는 db 구문으로 하는 것이 일반적임.
		System.out.println(">>> register seveice 진입.");
		return dao.insert(ins);
	}

	@Override
	public List<ProductVO> list() {
		System.out.println(">>> list seveice 진입.");
		return dao.selectList();
	}

	@Override
	public ProductVO detail(int pno) {
		System.out.println(">>> detail seveice 진입.");
		return dao.detail(pno);
	}

	@Override
	public int edit(ProductVO pno) {
		System.out.println(">>> edit seveice 진입.");
		return dao.edit(pno);
	}

	@Override
	public int remove(int pno) {
		System.out.println(">>> remove seveice 진입.");
		return dao.remove(pno);
	}
	
	

}