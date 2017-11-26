package skay.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import skay.model.api_StatusAndMessage;
import skay.model.api_UserResult;
import skay.model.tbl_user;
import skay.myapi.API_PathHost;
import skay.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/getall")
	private List<tbl_user> getAll() {
		return (List<tbl_user>) userService.findAll();
	}

	@RequestMapping(value = "/userupdate", method = RequestMethod.POST)
	public api_UserResult userUpdate(HttpServletRequest request, HttpServletResponse response, Model model) {
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		String nickname = request.getParameter("nickname");
		String birth = request.getParameter("birth");
		String phone = request.getParameter("phone");
		String emoticon = request.getParameter("emojiurl");
		Integer gender = Integer.parseInt(request.getParameter("gender"));

		System.out.println("user update" + userid + " - " + nickname + " - " + birth + " - " + phone + " - " + emoticon
				+ " - " + gender);

		tbl_user u = userService.findOne(userid);
		if (!nickname.equals("") && nickname != null) {
			u.setNickname(nickname);
		}
		if (!birth.equals("") && birth != null) {
			u.setBirth(birth);
		}
		if (!phone.equals("") && phone != null) {
			u.setPhone(phone);
		}
		if (!emoticon.equals("") && emoticon != null) {
			u.setEmoticon(emoticon.replace(API_PathHost.getLinkEmojis(), ""));
		}
		if (gender != null) {
			u.setGender(gender);
		}

		try {
			userService.save(u);
			return new api_UserResult(1, UpdateUserMessage(1), new tbl_user(u));
		} catch (Exception e) {
			System.out.println(e.toString());
			return new api_UserResult(2, UpdateUserMessage(2));
		}
	}

	@RequestMapping(value = "/userchangepass", method = RequestMethod.POST)
	public api_StatusAndMessage userChangePass(HttpServletRequest request, HttpServletResponse response, Model model) {
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		String newpass = request.getParameter("newpass");

		System.out.println("user change pass api - " + userid + " - " + newpass);

		tbl_user u = userService.findOne(userid);
		u.setPass(newpass);

		try {
			userService.save(u);
			return new api_StatusAndMessage(1, ChangePassrMessage(1));
		} catch (Exception e) {
			System.out.println(e.toString());
			return new api_StatusAndMessage(2, ChangePassrMessage(2));
		}
	}

	@RequestMapping(value = "/userchangeavatar", method = RequestMethod.POST)
	public api_UserResult userChangeavAtar(@RequestParam("avatar") MultipartFile file,
			@RequestParam("userid") Integer userid, HttpServletRequest request) {
		tbl_user u = userService.findOne(userid);
		String path = request.getServletContext().getRealPath("resources/images");
		String fileName = new API_File(path).saveFileWithName(file, "avatar" + userid);

		System.out.println("user change avatar api");

		if (!fileName.equals("fail")) {
			u.setAvata(fileName);
			userService.save(u);
			if (u.getAvatar().equals("https://forumhumgeduvn.000webhostapp.com/5skay/woman.png")
					|| u.getAvatar().equals("https://forumhumgeduvn.000webhostapp.com/5skay/man.png")) {
				return new api_UserResult(1, ChangeAvatarMessage(1), u);
			} else {
				if (new API_File(path).deleteFile("avatar" + userid)) {
					new API_File(path).saveFileWithName(file, "avatar" + userid);
					return new api_UserResult(1, ChangeAvatarMessage(1), u);
				} else {
					return new api_UserResult(2, ChangeAvatarMessage(2));
				}
			}
		} else {
			return new api_UserResult(2, ChangeAvatarMessage(2));
		}
	}

	public String UpdateUserMessage(int status) {
		if (status == 1) {
			return "Thay đổi thông tin thành công";
		} else {
			return "Lỗi";
		}
	}

	public String ChangePassrMessage(int status) {
		if (status == 1) {
			return "Thay đổi mật khẩu thành công";
		} else {
			return "Lỗi";
		}
	}

	public String ChangeAvatarMessage(int status) {
		if (status == 1) {
			return "Thay đổi avatar thành công";
		} else {
			return "Lỗi";
		}
	}
}
