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
    public void addItem(String memberId, int itemNo, int quantity) throws Exception {
        if (quantity < 1) quantity = 1;
        cartDAO.addOrUpdateCartItem(memberId, itemNo, quantity);
    }

    @Override
    public List<CartItemVO> getCartItems(String memberId) throws Exception {
        return cartDAO.selectCartItemsByMemberId(memberId);
    }

    @Override
    public void updateQty(int cartItemNo, int quantity) throws Exception {
        if (quantity < 1) quantity = 1;
        cartDAO.updateCartItemQty(cartItemNo, quantity);
    }

    @Override
    public void deleteItem(int cartItemNo) throws Exception {
        cartDAO.deleteCartItem(cartItemNo);
    }

    @Override
    public void clearCart(String memberId) throws Exception {
        cartDAO.clearCart(memberId);
    }
}
