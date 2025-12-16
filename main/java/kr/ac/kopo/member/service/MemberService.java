package kr.ac.kopo.member.service;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberService {
    void registerMember(MemberVO member) throws Exception;
    MemberVO login(String id, String password) throws Exception;
}
