package kr.ac.kopo.member.controller;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.service.MemberServiceImpl;
import kr.ac.kopo.member.vo.MemberVO;

public class MemberRegisterProcessController implements Controller {

	private final MemberService memberService = new MemberServiceImpl();

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {

		// 1. 파라미터 수집
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String passwordCheck = req.getParameter("passwordCheck");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		// 다시 그릴 때 사용할 폼 데이터
		MemberVO form = new MemberVO();
		form.setId(id);
		form.setName(name);
		form.setEmail(email);
		form.setPhone(phone);
		// 비밀번호는 보안상 다시 채우지 않음

		Map<String, String> errors = new HashMap<>();

		// 2. JS를 우회하는 경우를 대비한 "최소" 서버 검증
		// (아이디/비번/이름/전화번호 정도만 비어있는지 확인)
		if (isBlank(id)) {
			errors.put("id", "아이디를 입력해주세요.");
		}
		if (isBlank(password)) {
			errors.put("password", "비밀번호를 입력해주세요.");
		}
		if (isBlank(passwordCheck)) {
			errors.put("passwordCheck", "비밀번호 확인을 입력해주세요.");
		}
		if (!isBlank(password) && !password.equals(passwordCheck)) {
			errors.put("passwordCheck", "비밀번호가 일치하지 않습니다.");
		}
		if (isBlank(name)) {
			errors.put("name", "이름을 입력해주세요.");
		}
		if (isBlank(phone)) {
			errors.put("phone", "전화번호는 필수 입력입니다.");
		}

		// 최소 검증에서 걸리면 그대로 폼으로
		if (!errors.isEmpty()) {
			req.setAttribute("form", form);
			req.setAttribute("errors", errors);
			req.setAttribute("firstErrorField", errors.keySet().iterator().next());
			return "/member/registerForm.jsp";
		}

		// 3. 실제 회원가입 (아이디 중복 등은 Service에서 처리)
		try {
			MemberVO newMember = new MemberVO();
			newMember.setId(id);
			newMember.setPassword(password);
			newMember.setName(name);
			newMember.setEmail(email);
			newMember.setPhone(phone);

			memberService.registerMember(newMember);

		} catch (Exception e) {
			String msg = e.getMessage();
			if (msg == null || msg.isBlank()) {
				msg = "회원가입 처리 중 오류가 발생했습니다. 잠시 후 다시 시도해주세요.";
			}

			errors.put("id", msg); // 아이디 옆에 붙여서 보여줌
			req.setAttribute("form", form);
			req.setAttribute("errors", errors);
			req.setAttribute("firstErrorField", "id");

			return "/member/registerForm.jsp";
		}

		// 4. 성공 시 로그인 페이지로 이동
		return "redirect:/member/loginForm.do";
	}

	private boolean isBlank(String s) {
		return s == null || s.trim().isEmpty();
	}
}
