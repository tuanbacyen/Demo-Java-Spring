package skay.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skay.model.api_Login;
import skay.model.tbl_user;
import skay.myapi.API_PathHost;
import skay.service.UserService;

@RestController
public class LoginController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public api_Login loginByUserAndPass(HttpServletRequest request, HttpServletResponse response, Model model) {
		// get parameter
		String name = request.getParameter("username");
		String pwd = request.getParameter("pass");

		System.out.println("login - " + name + " - " + pwd);

		List<tbl_user> lstLogin = userService.login(name, API_EncodePassword.enCode(pwd));
		tbl_user user = userService.CheckUserHave(name);
		if (lstLogin.size() == 0) {
			if (user == null) {
				return new api_Login(2, LoginMessage(2));
			} else {
				return new api_Login(3, LoginMessage(3));
			}
		} else {
			user.setEmoticon(API_PathHost.getLinkEmojis() + user.getEmoticon());
			tbl_user lover;
			if (user.getCoupleid() == null || user.getCoupleid().equals("")) {
				lover = null;
			} else {
				String[] str = user.getCoupleid().split("_");
				String idLover = str[0];
				if (user.getUserid().toString() == idLover) {
					idLover = str[1];
				}
				lover = new tbl_user(userService.findOne(Integer.parseInt(idLover)));
				lover.setEmoticon(API_PathHost.getLinkEmojis() + lover.getEmoticon());
			}
			return new api_Login(1, LoginMessage(1), user, lover);
		}
	}

	public String LoginMessage(int status) {
		if (status == 1) {
			return "Login thành công";
		} else if (status == 2) {
			return "Không tồn tại user";
		} else {
			return "Mật khẩu không đúng";
		}
	}
}
