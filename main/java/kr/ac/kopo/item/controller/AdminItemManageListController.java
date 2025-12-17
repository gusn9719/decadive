package kr.ac.kopo.item.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.service.ItemServiceImpl;
import kr.ac.kopo.item.vo.ItemVO;
import kr.ac.kopo.member.vo.MemberVO;

public class AdminItemManageListController implements Controller {

	private ItemService itemService;

	public AdminItemManageListController() {
		itemService = new ItemServiceImpl();
	}

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession(false);
		MemberVO loginMember = (session == null) ? null : (MemberVO) session.getAttribute("loginMember");

		if (loginMember == null || loginMember.getType() != 1) {
			return "redirect:/member/loginForm.do";
		}

		// 관리자용: 전체 조회 (조건 없이)
		ItemVO param = new ItemVO();
		List<ItemVO> list = itemService.getItemList(param);

		req.setAttribute("itemList", list);

		return "/admin/itemManageList.jsp";
	}
}
