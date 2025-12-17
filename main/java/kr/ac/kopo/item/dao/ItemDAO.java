package kr.ac.kopo.item.dao;

import java.util.List;

import kr.ac.kopo.item.vo.ItemVO;

public interface ItemDAO {

	// 동적 조건(전체/연도/카테고리/검색) 리스트 조회
	List<ItemVO> selectByCondition(ItemVO param) throws Exception;

	ItemVO selectByNo(int itemNo) throws Exception;

	ItemVO selectDetailByNo(int itemNo) throws Exception;

	void insertItem(ItemVO item) throws Exception;

	void insertItemDetail(ItemVO item) throws Exception;

	void updateItem(ItemVO item) throws Exception;

	void deleteItem(int itemNo) throws Exception;

	void deleteItemDetail(int itemNo) throws Exception;

	void upsertItemDetail(ItemVO item) throws Exception;
	
	void deleteCartItemsByItemNo(int itemNo) throws Exception;
}
