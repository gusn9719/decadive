package kr.ac.kopo.item.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.service.ItemServiceImpl;
import kr.ac.kopo.item.vo.ItemVO;

public class AdminItemUpdateController implements Controller {

	private ItemService itemService = new ItemServiceImpl();

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ItemVO item = new ItemVO();
		item.setItemNo(Integer.parseInt(req.getParameter("itemNo")));
		item.setName(req.getParameter("name"));
		item.setPrice(Integer.parseInt(req.getParameter("price")));
		item.setEra(req.getParameter("era"));
		item.setCategory(req.getParameter("category"));
		item.setDescription(req.getParameter("description"));

		itemService.updateItem(item);

		return "redirect:/admin/itemManageList.do";
	}
}