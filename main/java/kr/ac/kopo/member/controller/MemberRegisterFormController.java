package kr.ac.kopo.member.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.framework.Controller;

public class MemberRegisterFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		return "/member/registerForm.jsp";
	}
}
