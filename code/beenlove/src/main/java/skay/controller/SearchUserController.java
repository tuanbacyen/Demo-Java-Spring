package skay.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skay.model.api_SearchUser;
import skay.model.tbl_user_search;
import skay.service.UserService;

@RestController
public class SearchUserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/searchuser", method = RequestMethod.POST)
	public api_SearchUser registerWithParam(HttpServletRequest request, HttpServletResponse response, Model model) {

		// get param
		String username = request.getParameter("username");
		String index = request.getParameter("index");
		String limit = request.getParameter("limit");

		// val
		int indexNext = -1;

		System.out.print("search user api - " + username + " - " + index + " - " + limit + "\n");

		// func
		API_PageCustom page = new API_PageCustom(index, limit);

		List<tbl_user_search> lstUserSearch = (List<tbl_user_search>) userService.findByUsernameEndWith(username,
				page.fromLimit(), page.toLimit() + 1);

		if (lstUserSearch.size() == 0 || lstUserSearch == null) {
			return new api_SearchUser(2, SearchMessage(2), indexNext, null);
		} else {
			if (lstUserSearch.size() > page.getItemLimit()) {
				indexNext = Integer.parseInt(index) + 1;
				lstUserSearch.remove(lstUserSearch.size() - 1);
			} else {
				indexNext = -1;
			}
			return new api_SearchUser(1, SearchMessage(1), indexNext, lstUserSearch);
		}
	}

	public String SearchMessage(int status) {
		if (status == 1) {
			return "Thành công";
		} else {
			return "Không có kết quả tìm kiếm";
		}
	}
}
