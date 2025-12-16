package kr.ac.kopo.item.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.service.ItemServiceImpl;
import kr.ac.kopo.item.vo.ItemVO;

public class ItemDetailController implements Controller {

	private ItemService itemService;

	public ItemDetailController() {
		itemService = new ItemServiceImpl();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String no = request.getParameter("itemNo");
		if (no == null || no.isBlank()) {
			return "redirect:/item/itemList.do";
		}

		int itemNo = Integer.parseInt(no);

		ItemVO item = itemService.getItem(itemNo);
		if (item == null) {
			return "redirect:/item/itemList.do";
		}

		request.setAttribute("item", item);

		return "/item/itemDetail.jsp";
	}
}
