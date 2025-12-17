package kr.ac.kopo.member.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.vo.MemberVO;

public class MemberMyPageController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		MemberVO loginMember = (MemberVO) req.getSession().getAttribute("loginMember");
		if (loginMember == null) {
			return "redirect:/member/loginForm.do";
		}

		req.setAttribute("member", loginMember);

		return "/member/myPage.jsp";
	}
}
