package kr.ac.kopo.member.service;

import java.util.List;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.dao.MemberDAOImpl;
import kr.ac.kopo.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;

	public MemberServiceImpl() {
		memberDAO = new MemberDAOImpl();
	}

	@Override
	public void registerMember(MemberVO member) throws Exception {

		// 아이디 중복이면 이 메시지를 MemberRegisterProcessController 에서 처리
		if (memberDAO.existsId(member.getId()) > 0) {
			throw new Exception("이미 존재하는 아이디입니다.");
		}

		memberDAO.insertMember(member);
	}

	@Override
	public MemberVO login(String id, String password) throws Exception {
		MemberVO param = new MemberVO(id, password);
		return memberDAO.findMemberForLogin(param);
	}

	@Override
	public List<MemberVO> getMemberList() throws Exception {
		return memberDAO.selectAllMembers();
	}

}
