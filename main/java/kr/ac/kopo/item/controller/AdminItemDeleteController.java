package kr.ac.kopo.item.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.service.ItemServiceImpl;
import kr.ac.kopo.member.vo.MemberVO;

public class AdminItemDeleteController implements Controller {

	private ItemService itemService;

	public AdminItemDeleteController() {
		itemService = new ItemServiceImpl();
	}

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		// 관리자 체크
		HttpSession session = req.getSession(false);
		MemberVO loginMember = (session == null) ? null : (MemberVO) session.getAttribute("loginMember");
		if (loginMember == null || loginMember.getType() != 1) {
			return "redirect:/member/loginForm.do";
		}

		int itemNo = Integer.parseInt(req.getParameter("itemNo"));
		itemService.deleteItem(itemNo);

		return "redirect:/admin/itemManageList.do";
	}
}
