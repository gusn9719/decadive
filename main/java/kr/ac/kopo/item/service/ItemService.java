package kr.ac.kopo.item.service;

import java.util.List;

import kr.ac.kopo.item.vo.ItemVO;

public interface ItemService {

	// 리스트 조회(전체/연도/카테고리/검색 공통)
	List<ItemVO> getItemList(ItemVO param) throws Exception;

	// 상세
	ItemVO getItem(int itemNo) throws Exception;

	// 관리자 상품 등록
	void registerItem(ItemVO item) throws Exception;

	void updateItem(ItemVO item) throws Exception;

	void deleteItem(int itemNo) throws Exception;
}
