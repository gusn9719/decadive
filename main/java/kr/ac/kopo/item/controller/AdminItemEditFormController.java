package kr.ac.kopo.item.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.service.ItemServiceImpl;
import kr.ac.kopo.item.vo.ItemVO;

public class AdminItemEditFormController implements Controller {

	private ItemService itemService = new ItemServiceImpl();

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		int itemNo = Integer.parseInt(req.getParameter("itemNo"));

		ItemVO item = itemService.getItem(itemNo);
		req.setAttribute("item", item);

		return "/admin/itemEditForm.jsp";
	}
}