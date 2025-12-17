package kr.ac.kopo.cart.service;

import java.util.List;

import kr.ac.kopo.cart.vo.CartItemVO;

public interface CartService {

    void addItem(String memberId, int itemNo, int quantity) throws Exception;

    List<CartItemVO> getCartItems(String memberId) throws Exception;

    void updateQty(int cartItemNo, int quantity) throws Exception;

    void deleteItem(int cartItemNo) throws Exception;

    void clearCart(String memberId) throws Exception;
}
