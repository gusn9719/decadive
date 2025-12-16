package kr.ac.kopo.cart.service;

import java.util.List;

import kr.ac.kopo.cart.dao.CartDAO;
import kr.ac.kopo.cart.dao.CartDAOImpl;
import kr.ac.kopo.cart.vo.CartItemVO;

public class CartServiceImpl implements CartService {

	private CartDAO cartDAO;

	public CartServiceImpl() {
		cartDAO = new CartDAOImpl();
	}

	@Override
	public List<CartItemVO> getCartItems(String memberId) throws Exception {
		return cartDAO.selectCartItemsByMemberId(memberId);
	}

	@Override
	public void addItem(String memberId, int itemNo, int quantity) throws Exception {
		cartDAO.addOrUpdateCartItem(memberId, itemNo, quantity);
	}

	@Override
	public void updateQuantity(int cartItemNo, int quantity) throws Exception {
		cartDAO.updateCartItemQty(cartItemNo, quantity);
	}

	@Override
	public void removeItem(int cartItemNo) throws Exception {
		cartDAO.deleteCartItem(cartItemNo);
	}

	@Override
	public void clear(String memberId) throws Exception {
		cartDAO.clearCart(memberId);
	}
}
