package kr.ac.kopo.cart.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.cart.service.CartService;
import kr.ac.kopo.cart.service.CartServiceImpl;
import kr.ac.kopo.cart.vo.CartItemVO;

public class CartListController implements Controller {

	private CartService cartService;

	public CartListController() {
		cartService = new CartServiceImpl();
	}

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession(false);
		MemberVO loginMember = (session != null) ? (MemberVO) session.getAttribute("loginMember") : null;

		if (loginMember == null) {
			return "redirect:/member/loginForm.do";
		}

		String memberId = loginMember.getId();

		List<CartItemVO> cartList = cartService.getCartItems(memberId);
		req.setAttribute("cartList", cartList);

		return "/cart/cartList.jsp";
	}
}
