package kr.ac.kopo.member.dao;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberDAO {
    void insertMember(MemberVO member) throws Exception;
    int existsId(String id) throws Exception;
    MemberVO findMemberForLogin(MemberVO member) throws Exception;
    MemberVO findMemberById(String id) throws Exception;
}
