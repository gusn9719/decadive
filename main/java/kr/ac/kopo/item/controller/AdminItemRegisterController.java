package kr.ac.kopo.item.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.item.service.ItemService;
import kr.ac.kopo.item.service.ItemServiceImpl;
import kr.ac.kopo.item.vo.ItemVO;

public class AdminItemRegisterController implements Controller {

	private ItemService itemService;

	public AdminItemRegisterController() {
		itemService = new ItemServiceImpl();
	}

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		// 1. 파라미터 추출
		String era = req.getParameter("era"); // 80s / 90s / 00s
		String category = req.getParameter("category"); // WALL / DESK ...
		String name = req.getParameter("name");
		String priceStr = req.getParameter("price");
		String desc = req.getParameter("description");

		int price = 0;
		try {
			price = Integer.parseInt(priceStr);
		} catch (NumberFormatException e) {
			req.setAttribute("errorMsg", "가격이 올바르지 않습니다.");
			return "/admin/itemForm.jsp";
		}

		// 2. 이미지 파일 Part 꺼내기
		Part imagePart = null;
		try {
			imagePart = req.getPart("imageFile");
		} catch (IOException | IllegalStateException e) {
			req.setAttribute("errorMsg", "이미지 파일을 읽는 중 오류가 발생했습니다.");
			return "/admin/itemForm.jsp";
		}

		if (imagePart == null || imagePart.getSize() == 0) {
			req.setAttribute("errorMsg", "이미지 파일을 선택해주세요.");
			return "/admin/itemForm.jsp";
		}

		// 3. 파일 저장 경로 계산
		// /resources/images/item/{era}/{category 소문자}/
		String lowerCategory = category.toLowerCase();

		String relativeDir = "/resources/images/item/" + era + "/" + lowerCategory;
		String realDir = req.getServletContext().getRealPath(relativeDir);

		File dir = new File(realDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		// 업로드된 원래 파일명
		String submittedName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();

		// 파일명 충돌 방지를 위해 prefix 붙이기
		String savedFileName = System.currentTimeMillis() + "_" + submittedName;

		// 실제 저장 풀 경로
		String fullPath = realDir + File.separator + savedFileName;

		// 4. 디스크에 파일 저장
		imagePart.write(fullPath);

		// 5. DB 에 저장할 image_path (컨텍스트 기준 경로)
		String imagePath = relativeDir + "/" + savedFileName; // 예) /resources/images/item/80s/wall/xxx.png

		// 6. VO 구성
		ItemVO item = new ItemVO();
		item.setEra(era);
		item.setCategory(category);
		item.setName(name);
		item.setPrice(price);
		item.setImagePath(imagePath);
		item.setDescription(desc);

		try {
			// 트랜잭션 내에서 item + detail 등록
			itemService.registerItem(item);
		} catch (Exception e) {
			// DB 실패하면, 방금 올린 이미지 삭제해 주는 게 깔끔함
			new File(fullPath).delete();
			req.setAttribute("errorMsg", "상품 등록 중 오류가 발생했습니다: " + e.getMessage());
			return "/admin/itemForm.jsp";
		}

		// 7. 성공하면 상품 리스트로 이동
		return "redirect:/item/itemList.do";
	}
}
