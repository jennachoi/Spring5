package co.jiwon.prj.member.service;

import java.util.List;

import co.jiwon.prj.member.vo.MemberVO;

public interface MemberService {
	
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo); 
	MemberVO memberLogin(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);

}
