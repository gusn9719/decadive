package kr.ac.kopo.item.dao;

import java.util.List;

import kr.ac.kopo.item.vo.ItemVO;

public interface ItemDAO {

	// 동적 조건(전체/연도/카테고리/검색) 리스트 조회
	List<ItemVO> selectByCondition(ItemVO param) throws Exception;

	// 상세 페이지용 단건 조회
	ItemVO selectByNo(int itemNo) throws Exception;

	ItemVO selectDetailByNo(int itemNo) throws Exception;

	void insertItem(ItemVO item) throws Exception;

	void insertItemDetail(ItemVO item) throws Exception;
}
