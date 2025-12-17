package kr.ac.kopo.admin.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.service.MemberServiceImpl;
import kr.ac.kopo.member.vo.MemberVO;

public class AdminMemberListController implements Controller {

	private MemberService memberService;

	public AdminMemberListController() {
		memberService = new MemberServiceImpl();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 관리자 체크
		HttpSession session = request.getSession(false);
		MemberVO loginMember = (session == null) ? null : (MemberVO) session.getAttribute("loginMember");

		if (loginMember == null || loginMember.getType() != 1) {
			return "redirect:/member/loginForm.do";
		}

		// 전체 회원 조회
		List<MemberVO> memberList = memberService.getMemberList();

		request.setAttribute("memberList", memberList);
		return "/admin/memberList.jsp";
	}
}
