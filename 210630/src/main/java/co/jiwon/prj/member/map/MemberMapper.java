package co.jiwon.prj.member.map;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.jiwon.prj.member.vo.MemberVO;

@Mapper
public interface MemberMapper {
	
	List<MemberVO> memberSelectList();
	
	MemberVO memberSelect(MemberVO vo);

	MemberVO memberLogin(MemberVO vo);

	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);

}
