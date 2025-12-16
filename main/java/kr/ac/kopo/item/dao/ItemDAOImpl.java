package kr.ac.kopo.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.item.vo.ItemVO;
import kr.ac.kopo.mybatis.MyConfig;

public class ItemDAOImpl implements ItemDAO {

	private SqlSession session;

	public ItemDAOImpl() {
		session = new MyConfig().getSession();
	}

	@Override
	public List<ItemVO> selectByCondition(ItemVO param) throws Exception {
		return session.selectList("dao.ItemDAO.selectByCondition", param);
	}

	@Override
	public ItemVO selectByNo(int itemNo) throws Exception {
		return session.selectOne("dao.ItemDAO.selectByNo", itemNo);
	}

    @Override
    public ItemVO selectDetailByNo(int itemNo) throws Exception {
        return session.selectOne("dao.ItemDAO.selectDetailByNo", itemNo);
    }
	
	@Override
	public void insertItem(ItemVO item) throws Exception {
		session.insert("dao.ItemDAO.insertItem", item);
		session.commit();
	}

	@Override
	public void insertItemDetail(ItemVO item) throws Exception {
		session.insert("dao.ItemDAO.insertItemDetail", item);
		session.commit();
	}
}
