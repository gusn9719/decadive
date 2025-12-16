package kr.ac.kopo.cart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.cart.vo.CartItemVO;
import kr.ac.kopo.mybatis.MyConfig;

public class CartDAOImpl implements CartDAO {

    private SqlSession session;

    public CartDAOImpl() {
        session = new MyConfig().getSession();
    }

    @Override
    public List<CartItemVO> selectCartItemsByMemberId(String memberId) throws Exception {
        return session.selectList("dao.CartDAO.selectCartItemsByMemberId", memberId);
    }

    @Override
    public void addOrUpdateCartItem(String memberId, int itemNo, int quantity) throws Exception {

        // 1) 회원의 cart_no 찾기
        Integer cartNo = session.selectOne("dao.CartDAO.selectCartNoByMemberId", memberId);

        // 2) 없으면 새로 생성
        if (cartNo == null) {
            int newCartNo = session.selectOne("dao.CartDAO.nextCartNo");

            Map<String, Object> param = new HashMap<>();
            param.put("cartNo", newCartNo);
            param.put("memberId", memberId);

            session.insert("dao.CartDAO.insertCartMaster", param);
            cartNo = newCartNo;
        }

        // 3) 이미 담긴 상품인지 확인
        Map<String, Object> param = new HashMap<>();
        param.put("cartNo", cartNo);
        param.put("itemNo", itemNo);

        Integer existsQty = session.selectOne("dao.CartDAO.selectCartItemQty", param);

        if (existsQty == null) {
            // 새로 추가
            param.put("quantity", quantity);
            session.insert("dao.CartDAO.insertCartItem", param);
        } else {
            // 수량 증가
            param.put("quantity", quantity);
            session.update("dao.CartDAO.updateCartItemAddQty", param);
        }

        session.commit();
        session.close();
    }

    @Override
    public void updateCartItemQty(int cartItemNo, int quantity) throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("cartItemNo", cartItemNo);
        param.put("quantity", quantity);

        session.update("dao.CartDAO.updateCartItemQty", param);
        session.commit();
        session.close();
    }

    @Override
    public void deleteCartItem(int cartItemNo) throws Exception {
        session.delete("dao.CartDAO.deleteCartItem", cartItemNo);
        session.commit();
        session.close();
    }

    @Override
    public void clearCart(String memberId) throws Exception {
        session.delete("dao.CartDAO.clearCartByMemberId", memberId);
        session.commit();
        session.close();
    }
}
