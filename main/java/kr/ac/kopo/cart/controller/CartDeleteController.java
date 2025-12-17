package kr.ac.kopo.cart.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.cart.service.CartService;
import kr.ac.kopo.cart.service.CartServiceImpl;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.vo.MemberVO;

public class CartDeleteController implements Controller {

	private CartService cartService;

	public CartDeleteController() {
		cartService = new CartServiceImpl();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);
		MemberVO loginMember = (session != null) ? (MemberVO) session.getAttribute("loginMember") : null;

		if (loginMember == null) {
			return "redirect:/member/loginForm.do";
		}

		int cartItemNo = Integer.parseInt(request.getParameter("cartItemNo"));

		cartService.deleteItem(cartItemNo);

		return "redirect:/cart/cartList.do";
	}
}
