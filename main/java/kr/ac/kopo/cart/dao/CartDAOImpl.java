package kr.ac.kopo.cart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.cart.vo.CartItemVO;
import kr.ac.kopo.mybatis.MyConfig;

public class CartDAOImpl implements CartDAO {

	@Override
	public List<CartItemVO> selectCartItemsByMemberId(String memberId) throws Exception {
		try (SqlSession session = new MyConfig().getSession()) {
			return session.selectList("dao.CartDAO.selectCartItemsByMemberId", memberId);
		}
	}

	@Override
	public void addOrUpdateCartItem(String memberId, int itemNo, int quantity) throws Exception {

		// 여러 SQL을 한 트랜잭션으로 묶어야 안전함
		try (SqlSession session = new MyConfig().getSession()) {

			// 1) 회원 cart_no 조회
			Integer cartNo = session.selectOne("dao.CartDAO.selectCartNoByMemberId", memberId);

			// 2) 없으면 cart master 생성
			if (cartNo == null) {
				int newCartNo = session.selectOne("dao.CartDAO.nextCartNo");

				Map<String, Object> masterParam = new HashMap<>();
				masterParam.put("cartNo", newCartNo);
				masterParam.put("memberId", memberId);

				session.insert("dao.CartDAO.insertCartMaster", masterParam);
				cartNo = newCartNo;
			}

			// 3) 담긴 상품 존재 여부 확인
			Map<String, Object> param = new HashMap<>();
			param.put("cartNo", cartNo);
			param.put("itemNo", itemNo);

			Integer existsQty = session.selectOne("dao.CartDAO.selectCartItemQty", param);

			
			param.put("quantity", quantity);

			if (existsQty == null) {
				session.insert("dao.CartDAO.insertCartItem", param);
			} else {
				session.update("dao.CartDAO.updateCartItemAddQty", param);
			}

			session.commit();
		}
	}

	@Override
	public void updateCartItemQty(int cartItemNo, int quantity) throws Exception {
		try (SqlSession session = new MyConfig().getSession()) {
			Map<String, Object> param = new HashMap<>();
			param.put("cartItemNo", cartItemNo);
			param.put("quantity", quantity);

			session.update("dao.CartDAO.updateCartItemQty", param);
			session.commit();
		}
	}

	@Override
	public void deleteCartItem(int cartItemNo) throws Exception {
		try (SqlSession session = new MyConfig().getSession()) {
			session.delete("dao.CartDAO.deleteCartItem", cartItemNo);
			session.commit();
		}
	}

	@Override
	public void clearCart(String memberId) throws Exception {
		try (SqlSession session = new MyConfig().getSession()) {
			session.delete("dao.CartDAO.clearCartByMemberId", memberId);
			session.commit();
		}
	}
}
