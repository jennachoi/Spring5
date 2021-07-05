package co.jiwon.prj.member.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.jiwon.prj.member.service.MemberService;
import co.jiwon.prj.member.vo.MemberVO;

@RestController // 비동기 통신을 위한 컨트롤러 자체에 어노테이션 걸어줘도 됨.
//@Controller
public class MemberRestController {

	@Autowired
	private MemberService memberDao;

	@ResponseBody // 적용할 메소드에 어노테이션 걸어주는 것도 가능
	@RequestMapping("ajax/itron")
	public String ajaxItron() {
		return null;
	}

	@PostMapping("ajax/members")
	public List<MemberVO> members(@RequestBody String body) {
		System.out.println(body);
		return memberDao.memberSelectList();
	}
	
	@GetMapping("api/member")
	public List<MemberVO> memberList() {
		return memberDao.memberSelectList();
	}
	
}
