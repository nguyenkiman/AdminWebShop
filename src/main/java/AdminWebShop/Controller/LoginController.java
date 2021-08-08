package AdminWebShop.Controller;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class LoginController {
	
	@GetMapping("")
	public String login() {
		return "index";
	}
	@PostMapping("/login")
	public String checklogin(@RequestParam String email,@RequestParam String password) {
		
		if(email.equals("admin") && password.equals("admin")) {
			return "redirect:/Product";
		}
		return "index";
		
	}
}
