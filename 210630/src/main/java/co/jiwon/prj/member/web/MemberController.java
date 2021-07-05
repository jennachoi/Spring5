package co.jiwon.prj.member.web;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.jiwon.prj.common.Encryption;
import co.jiwon.prj.member.service.MemberService;
import co.jiwon.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberDao;
	
	@RequestMapping("memberList")
	public String memberSelectList(Model model) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = memberDao.memberSelectList();
		model.addAttribute("members", list);
		return "member/memberList";
	}
	
	@RequestMapping("memberInputForm")
	public String memberInputForm(@ModelAttribute("member") MemberVO vo, Model model) {
		List<String> loginType = new ArrayList<String>();	 // ${loginType}에 들어갈 값 만들어줌
		loginType.add("일반회원");
		loginType.add("기업회원");
		loginType.add("잡회원");
		model.addAttribute("loginType", loginType);
		
		return "member/memberInputForm";
	}
	
	@RequestMapping("memberRegister")
	public String memberRegister(MemberVO vo, Model model) throws NoSuchAlgorithmException {
		Encryption enc = new Encryption(); // 암호화 모듈 호출
		MultipartFile file = vo.getFile(); // 파일객체를 받음
		String fileName = file.getOriginalFilename();
		vo.setFileName(fileName);
		
		//DB입력
		vo.setPassword(enc.typeTwo(vo.getPassword()));	// 패스워드 암호화해서 담아준다
		int b = memberDao.memberInsert(vo);
		System.out.println(b);
		int n = memberDao.memberInsert(vo);
		if(n!= 0) {
			model.addAttribute("msg", "회원가입이 성공했습니다.");
		} else 
			model.addAttribute("msg", "회원가입이 실패했습니다.");
		
		//파일 업로드 구현하기
		return "member/memberRegister";
	}
	
	@RequestMapping("memberLoginForm")
	public String memberLoginForm(@ModelAttribute("member") MemberVO vo, HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");	// 세션 객체의 ID값 불러오기
		model.addAttribute("id", id);
		return "member/memberLoginForm";
	}
	
	@PostMapping("memberLogin")
	public String memberLogin(MemberVO vo, Model model, HttpSession session) throws NoSuchAlgorithmException {
		Encryption enc = new Encryption();
		vo.setPassword(enc.typeTwo(vo.getPassword()));	
		
		vo = memberDao.memberLogin(vo);
		if( vo != null) {
			session.setAttribute("id", vo.getEmail()); 	// session 만들기
			session.setAttribute("name", vo.getName());
			model.addAttribute("member", vo);
		} else {
			session.invalidate(); 	// 세션삭제
		}
		
		return "member/memberLogin";
	}
	
	// 비동기 방식으로 가져와보기
	@RequestMapping("api/memberList")
	@ResponseBody
	public List<MemberVO> apiMemberList() {
		return memberDao.memberSelectList();
	}
}
