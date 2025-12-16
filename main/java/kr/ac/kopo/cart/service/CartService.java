package kr.ac.kopo.cart.service;

import java.util.List;

import kr.ac.kopo.cart.vo.CartItemVO;

public interface CartService {

    List<CartItemVO> getCartItems(String memberId) throws Exception;

    void addItem(String memberId, int itemNo, int quantity) throws Exception;

    void updateQuantity(int cartItemNo, int quantity) throws Exception;

    void removeItem(int cartItemNo) throws Exception;

    void clear(String memberId) throws Exception;
}
