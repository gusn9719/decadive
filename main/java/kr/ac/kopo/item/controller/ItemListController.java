package kr.ac.kopo.item.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.service.ItemServiceImpl;
import kr.ac.kopo.item.vo.ItemVO;

public class ItemListController implements Controller {

	private ItemService itemService;

	public ItemListController() {
		itemService = new ItemServiceImpl();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String era = request.getParameter("era"); // 80s/90s/00s
		String category = request.getParameter("category"); // FASHION/TECH/...
		String keyword = request.getParameter("keyword"); // 이름 검색어 (검색 폼 name="keyword")

		ItemVO param = new ItemVO();
		if (era != null && !era.isBlank()) {
			param.setEra(era);
		}
		if (category != null && !category.isBlank()) {
			param.setCategory(category);
		}
		if (keyword != null && !keyword.isBlank()) {
			param.setName(keyword);
		}

		System.out.println("era param=[" + request.getParameter("era") + "]");
		System.out.println("category param=[" + request.getParameter("category") + "]");

		
		List<ItemVO> itemList = itemService.getItemList(param);

		request.setAttribute("itemList", itemList);
		request.setAttribute("era", era);
		request.setAttribute("category", category);
		request.setAttribute("keyword", keyword);

		return "/item/itemList.jsp";
	}
}
