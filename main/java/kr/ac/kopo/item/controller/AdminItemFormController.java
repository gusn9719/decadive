package kr.ac.kopo.item.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.vo.MemberVO;

public class AdminItemFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession(false);
		MemberVO loginMember = (session == null) ? null : (MemberVO) session.getAttribute("loginMember");

		// 관리자 체크 (type == 1)
		if (loginMember == null || loginMember.getType() != 1) {
			return "redirect:/member/loginForm.do";
		}

		return "/admin/itemForm.jsp";
	}
}
