package kr.ac.kopo.cart.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.cart.service.CartService;
import kr.ac.kopo.cart.service.CartServiceImpl;

public class CartAddController implements Controller {

	private CartService cartService;

	public CartAddController() {
		cartService = new CartServiceImpl();
	}

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession(false);
		MemberVO loginMember = (session != null) ? (MemberVO) session.getAttribute("loginMember") : null;

		if (loginMember == null) {
			// 로그인 안 되어 있으면 로그인 페이지로
			return "redirect:/member/loginForm.do";
		}

		String memberId = loginMember.getId();

		String itemNoParam = req.getParameter("itemNo");
		String qtyParam = req.getParameter("quantity");

		int itemNo = Integer.parseInt(itemNoParam);
		int qty = (qtyParam == null || qtyParam.isBlank()) ? 1 : Integer.parseInt(qtyParam);

		cartService.addItem(memberId, itemNo, qty);

		// 어디서 왔는지에 따라 다시 보내고 싶은데,
		// 일단 간단히 장바구니 목록으로 보냄
		return "redirect:/cart/cartList.do";
	}
}
