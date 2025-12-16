package kr.ac.kopo.member.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.framework.Controller;

public class MemberLogoutController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        
        HttpSession session = req.getSession();
        session.invalidate();   

        return "redirect:/item/itemList.do"; 
    }
}
