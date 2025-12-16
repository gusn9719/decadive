package kr.ac.kopo.member.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.service.MemberServiceImpl;
import kr.ac.kopo.member.vo.MemberVO;

public class MemberLoginProcessController implements Controller {

    private MemberService service = new MemberServiceImpl();

    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        String id = req.getParameter("id");
        String pw = req.getParameter("password");

        MemberVO loginMember = service.login(id, pw);

        if (loginMember == null) {
            req.setAttribute("msg", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "/member/loginForm.jsp";
        }

        HttpSession session = req.getSession();
        session.setAttribute("loginMember", loginMember);

        return "redirect:/";
    }
}
