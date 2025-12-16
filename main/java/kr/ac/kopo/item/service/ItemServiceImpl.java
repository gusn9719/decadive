package kr.ac.kopo.item.service;

import java.util.List;

import kr.ac.kopo.item.dao.ItemDAO;
import kr.ac.kopo.item.dao.ItemDAOImpl;
import kr.ac.kopo.item.vo.ItemVO;

public class ItemServiceImpl implements ItemService {

	private ItemDAO itemDAO;

	public ItemServiceImpl() {
		itemDAO = new ItemDAOImpl();
	}

	@Override
	public List<ItemVO> getItemList(ItemVO param) throws Exception {
		return itemDAO.selectByCondition(param);
	}

	@Override
	public ItemVO getItem(int itemNo) throws Exception {
		// 이제는 상세용 쿼리 사용 (description 포함)
		return itemDAO.selectDetailByNo(itemNo);
	}

	@Override
	public void registerItem(ItemVO item) throws Exception {

		itemDAO.insertItem(item); // itemNo + imagePath 저장
		itemDAO.insertItemDetail(item); // description 저장
	}
}
