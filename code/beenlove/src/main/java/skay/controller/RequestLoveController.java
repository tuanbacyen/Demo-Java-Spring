package skay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skay.model.api_EnumNotification;
import skay.model.api_RequestLoveAOC;
import skay.model.api_RequestLoveCreate;
import skay.model.tbl_request_love;
import skay.service.NotificationService;
import skay.service.RequestLoveService;
import skay.service.UserService;

@RestController
public class RequestLoveController {
	@Autowired
	RequestLoveService requestLoveService;

	@Autowired
	UserService userService;
	
	@Autowired
	NotificationService notificationService;

	@RequestMapping(value = "/requestlovecreate", method = RequestMethod.POST)
	public api_RequestLoveCreate createRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
		Integer senderid = Integer.parseInt(request.getParameter("senderid"));
		Integer receiveid = Integer.parseInt(request.getParameter("receiveid"));

		System.out.println("request love create api - " + senderid + " - " + receiveid);

		tbl_request_love rl = new tbl_request_love(senderid, receiveid, "request");
		try {
			requestLoveService.create(rl);
			notificationService.saveDataWithReceiveid(receiveid, api_EnumNotification.HAVE_REQUEST_LOVE.getMess());
			return new api_RequestLoveCreate(1, RLMessage(1), rl);
		} catch (Exception e) {
			return new api_RequestLoveCreate(2, RLMessage(2));
		}
	}

	@RequestMapping(value = "/requestloveaoc", method = RequestMethod.POST)
	public api_RequestLoveAOC requestloveaoc(HttpServletRequest request, HttpServletResponse response, Model model) {
		Integer senderid = Integer.parseInt(request.getParameter("senderid"));
		Integer receiveid = Integer.parseInt(request.getParameter("receiveid"));
		String state = request.getParameter("state");

		System.out.println("request love aoc api - " + senderid + " - " + receiveid + " - " + state);

		tbl_request_love rl = requestLoveService.findToEdit(senderid, receiveid);

		if (rl == null) {
			return new api_RequestLoveAOC(2, RLMessage(2));
		} else {
			if (state.equals("cancel")) {
				requestLoveService.delete(rl.getReceiveid());
				notificationService.saveDataWithReceiveid(rl.getReceiveid(), api_EnumNotification.HAVE_REQUEST_LOVE.getMess());
				return new api_RequestLoveAOC(1, RLMessage(1));
			} else if (state.equals("accept")) {
				rl.setState("accept");
				requestLoveService.save(rl);
				String coupleid = senderid + "_" + receiveid;
				if (userService.findOneToSave(senderid, coupleid) && userService.findOneToSave(receiveid, coupleid)) {
					notificationService.saveDataWithReceiveid(rl.getSenderid(), api_EnumNotification.HAVE_REQUEST_LOVE.getMess());
					return new api_RequestLoveAOC(1, RLMessage(1), rl);
				} else {
					return new api_RequestLoveAOC(2, RLMessage(2));
				}
			}
		}
		return new api_RequestLoveAOC(2, RLMessage(2));
	}

	public String RLMessage(int status) {
		if (status == 1) {
			return "Thành công";
		} else {
			return "Lỗi";
		}
	}

}
