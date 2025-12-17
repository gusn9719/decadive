package kr.ac.kopo.admin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.vo.MemberVO;

public class AdminOrderManageListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);
		MemberVO loginMember = (session == null) ? null : (MemberVO) session.getAttribute("loginMember");

		if (loginMember == null || loginMember.getType() != 1) {
			return "redirect:/member/loginForm.do";
		}

		return "/admin/orderManageList.jsp";
	}
}
