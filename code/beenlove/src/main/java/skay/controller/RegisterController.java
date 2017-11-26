package skay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skay.model.api_Register;
import skay.model.tbl_user;
import skay.service.UserService;

@RestController
public class RegisterController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public api_Register registerWithParam(HttpServletRequest request, HttpServletResponse response, Model model) {

		// get param
		String username = request.getParameter("username");
		String pwd = request.getParameter("pass");
		String nickname = request.getParameter("nickname");
		String bithday = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");

		System.out.println("register - " + username + " - " + pwd + " - " + nickname + " - " + bithday + " - " + gender
				+ " - " + phone);
		// check return
		if (!API_CheckAll.checkEmail(username)) {
			return new api_Register(2, ReMessage(2));
		} else {
			if (userService.CheckUserHave(username) == null) {

				String avata = "https://forumhumgeduvn.000webhostapp.com/5skay/woman.png";
				if (gender.equals("1")) {
					avata = "https://forumhumgeduvn.000webhostapp.com/5skay/man.png";
				}

				tbl_user user = new tbl_user(null, username, API_EncodePassword.enCode(pwd), nickname, bithday,
						Integer.parseInt(gender), phone, avata,
						"https://forumhumgeduvn.000webhostapp.com/5skay/emoticon.png");
				userService.save(user);
				return new api_Register(1, ReMessage(1), user);

			} else {
				return new api_Register(3, ReMessage(3));
			}
		}
	}

	public String ReMessage(int status) {
		if (status == 1) {
			return "Register thành công";
		} else if (status == 2) {
			return "Email không hợp lệ";
		} else {
			return "Đã tồn tại User trong hệ thống";
		}
	}
}
