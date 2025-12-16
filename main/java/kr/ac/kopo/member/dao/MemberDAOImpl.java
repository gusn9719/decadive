package kr.ac.kopo.member.dao;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.mybatis.MyConfig;

public class MemberDAOImpl implements MemberDAO {

    private SqlSession session;

    public MemberDAOImpl() {
        session = new MyConfig().getSession();
    }

    @Override
    public void insertMember(MemberVO member) throws Exception {
        session.insert("dao.MemberDAO.insertMember", member);
        session.commit();
    }

    @Override
    public int existsId(String id) throws Exception {
        return session.selectOne("dao.MemberDAO.existsId", id);
    }

    @Override
    public MemberVO findMemberForLogin(MemberVO member) throws Exception {
        return session.selectOne("dao.MemberDAO.findMemberForLogin", member);
    }

    @Override
    public MemberVO findMemberById(String id) throws Exception {
        return session.selectOne("dao.MemberDAO.findMemberById", id);
    }
}
