package co.jiwon.prj;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.jiwon.prj.common.BuncyEncryption;

@Controller
public class HomeController {
	
	@RequestMapping("home")
	public String home(Model model) {
		BuncyEncryption bn = new BuncyEncryption();
		String plainText = "0102-54112";	 // 평문
		//byte[] bytes = bn.encrypt(plainText);
		String cyperText = Base64.toBase64String(bn.encrypt(plainText));	// 암호문
		
		//byte[] bytes2 = bn.decrypt(cyperText);
		String decryptionText = Base64.toBase64String(bn.decrypt(cyperText));	// 복호문
		
		model.addAttribute("plainText", plainText);
		model.addAttribute("cyperText", cyperText);
		model.addAttribute("decryptionText", decryptionText);
		return "home";
	}
	
	@RequestMapping("step1")
	public String step1() {
		return "step1";
	}

}
