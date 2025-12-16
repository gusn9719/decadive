package kr.ac.kopo.cart.dao;

import java.util.List;

import kr.ac.kopo.cart.vo.CartItemVO;

public interface CartDAO {

	List<CartItemVO> selectCartItemsByMemberId(String memberId) throws Exception;

	void addOrUpdateCartItem(String memberId, int itemNo, int quantity) throws Exception;

	void updateCartItemQty(int cartItemNo, int quantity) throws Exception;

	void deleteCartItem(int cartItemNo) throws Exception;

	void clearCart(String memberId) throws Exception;
}
