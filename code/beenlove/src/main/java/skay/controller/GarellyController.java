package skay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skay.model.api_EnumNotification;
import skay.model.api_StatusAndMessage;
import skay.model.tbl_garelly;
import skay.service.GarellyService;
import skay.service.NotificationService;

@RestController
public class GarellyController {
	@Autowired
	GarellyService garellyService;

	@Autowired
	NotificationService notificationService;

	String pathSaveImage = "resources/images";

	@RequestMapping(value = "/garellydelete", method = RequestMethod.POST)
	public api_StatusAndMessage anivesarryDelete(HttpServletRequest request, HttpServletResponse response,
			Model model) {

		String path = request.getServletContext().getRealPath(pathSaveImage);

		// get param
		Integer garellyid = Integer.parseInt(request.getParameter("garellyid"));
		int user_id_send = Integer.parseInt(request.getParameter("user_id_send"));

		System.out.println("garelly delete api - " + garellyid + " - " + user_id_send);
		try {
			tbl_garelly g = garellyService.getOne(garellyid);
			
			if (new API_File(path).deleteFileWithFileName(g.getUrlimage())) {
				notificationService.saveData(user_id_send, api_EnumNotification.DELETE_GARELLY.getMess());
				garellyService.delete(garellyid);
				return new api_StatusAndMessage(1, GMessage(1));
			} else {
				return new api_StatusAndMessage(2, GMessage(2));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return new api_StatusAndMessage(2, GMessage(2));
		}
	}

	public String GMessage(int status) {
		if (status == 1) {
			return "Thành công";
		} else {
			return "Lỗi";
		}
	}
}
