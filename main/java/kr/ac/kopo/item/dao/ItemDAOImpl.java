package kr.ac.kopo.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.item.vo.ItemVO;
import kr.ac.kopo.mybatis.MyConfig;

public class ItemDAOImpl implements ItemDAO {

	@Override
	public List<ItemVO> selectByCondition(ItemVO param) throws Exception {
		try (SqlSession session = new MyConfig().getSession()) {
			return session.selectList("dao.ItemDAO.selectByCondition", param);
		}
	}

	@Override
	public ItemVO selectByNo(int itemNo) throws Exception {
		try (SqlSession session = new MyConfig().getSession()) {
			return session.selectOne("dao.ItemDAO.selectByNo", itemNo);
		}
	}

	@Override
	public ItemVO selectDetailByNo(int itemNo) throws Exception {
		try (SqlSession session = new MyConfig().getSession()) {
			return session.selectOne("dao.ItemDAO.selectDetailByNo", itemNo);
		}
	}

	@Override
	public void insertItem(ItemVO item) throws Exception {
		try (SqlSession session = new MyConfig().getSession()) {
			session.insert("dao.ItemDAO.insertItem", item);
			session.commit();
		}
	}

	@Override
	public void insertItemDetail(ItemVO item) throws Exception {
		try (SqlSession session = new MyConfig().getSession()) {
			session.insert("dao.ItemDAO.insertItemDetail", item);
			session.commit();
		}
	}

	@Override
	public void updateItem(ItemVO item) throws Exception {
		try (SqlSession session = new MyConfig().getSession()) {
			session.update("dao.ItemDAO.updateItem", item);
			session.commit();
		}
	}

	@Override
	public void deleteItem(int itemNo) throws Exception {
		try (SqlSession session = new MyConfig().getSession()) {
			session.delete("dao.ItemDAO.deleteItem", itemNo);
			session.commit();
		}
	}

	@Override
	public void deleteItemDetail(int itemNo) throws Exception {
		try (SqlSession session = new MyConfig().getSession()) {
			session.delete("dao.ItemDAO.deleteItemDetail", itemNo);
			session.commit();
		}
	}

	@Override
	public void upsertItemDetail(ItemVO item) throws Exception {
		try (SqlSession session = new MyConfig().getSession()) {
			session.update("dao.ItemDAO.upsertItemDetail", item);
			session.commit();
		}
	}
	
	@Override
	public void deleteCartItemsByItemNo(int itemNo) throws Exception {
		try (SqlSession session = new MyConfig().getSession()) {
			session.delete("dao.ItemDAO.deleteCartItemsByItemNo", itemNo);
			session.commit();
		}
	}
}

/*
 * 원래 session을 교수님께 배운대로 했었는데, 알 수 없는 오류들이 계손 나와서 try 리소스? 문으로 바꿔봄 public class
 * ItemDAOImpl implements ItemDAO {
 * 
 * private SqlSession session;
 * 
 * public ItemDAOImpl() { session = new MyConfig().getSession(); }
 * 
 * @Override public List<ItemVO> selectByCondition(ItemVO param) throws
 * Exception { return session.selectList("dao.ItemDAO.selectByCondition",
 * param); }
 * 
 * @Override public ItemVO selectByNo(int itemNo) throws Exception { return
 * session.selectOne("dao.ItemDAO.selectByNo", itemNo); }
 * 
 * @Override public ItemVO selectDetailByNo(int itemNo) throws Exception {
 * return session.selectOne("dao.ItemDAO.selectDetailByNo", itemNo); }
 * 
 * @Override public void insertItem(ItemVO item) throws Exception {
 * session.insert("dao.ItemDAO.insertItem", item); session.commit(); }
 * 
 * @Override public void insertItemDetail(ItemVO item) throws Exception {
 * session.insert("dao.ItemDAO.insertItemDetail", item); session.commit(); } }
 */
