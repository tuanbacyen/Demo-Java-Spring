package skay.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skay.model.api_EnumNotification;
import skay.model.api_Event;
import skay.model.api_EventCreate;
import skay.model.api_StatusAndMessage;
import skay.model.tbl_event;
import skay.myapi.API_PathHost;
import skay.service.EventService;
import skay.service.NotificationService;

@RestController
public class EventController {

	@Autowired
	EventService eventService;

	@Autowired
	NotificationService notificationService;

	@RequestMapping(value = "/event", method = RequestMethod.POST)
	public api_Event event(HttpServletRequest request, HttpServletResponse response, Model model) {
		// get param
		String coupleid = request.getParameter("coupleid");
		String index = request.getParameter("index");
		String limit = request.getParameter("limit");

		// val
		int indexNext = -1;

		System.out.print("event api - " + coupleid + " - " + index + " - " + limit + "\n");

		// func
		API_PageCustom page = new API_PageCustom(index, limit);

		List<tbl_event> lstEven = eventService.getAllWithCoupleId(coupleid, page.fromLimit(), page.toLimit() + 1);

		if (lstEven.size() == 0 || lstEven == null) {
			return new api_Event(2, eventMessage(2), indexNext, null);
		} else {
			if (lstEven.size() > page.getItemLimit()) {
				indexNext = Integer.parseInt(index) + 1;
				lstEven.remove(lstEven.size() - 1);
			} else {
				indexNext = -1;
			}
			return new api_Event(1, eventMessage(1), indexNext, lstEven);
		}
	}

	@RequestMapping(value = "/eventcreate", method = RequestMethod.POST)
	public api_EventCreate eventCreate(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String coupleid = request.getParameter("coupleid");
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String alterday = request.getParameter("alterday");
		String emoticon = request.getParameter("emoticon");
		int user_id_send = Integer.parseInt(request.getParameter("user_id_send"));

		System.out.println("event create - " + coupleid + " - " + name + " - " + date);

		if (coupleid.equals("") || name.equals("") || date.equals("") || emoticon.equals("")) {
			return new api_EventCreate(2, eventMessage(2));
		} else {
			String emojiName = emoticon.replace(API_PathHost.getLinkEmojis(), "");
			tbl_event ev = new tbl_event(coupleid, name, date, alterday, emojiName);
			eventService.save(ev);
			notificationService.saveData(user_id_send, coupleid, api_EnumNotification.CREATE_EVENT.getMess());
			ev.setEmoticon(emoticon);
			return new api_EventCreate(1, eventMessage(1), ev);
		}
	}

	@RequestMapping(value = "/eventupdate", method = RequestMethod.POST)
	public api_EventCreate eventUpdate(HttpServletRequest request, HttpServletResponse response, Model model) {

		int eventid = Integer.parseInt(request.getParameter("eventid"));
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String alterday = request.getParameter("alterday");
		String emoticon = request.getParameter("emoticon");
		int user_id_send = Integer.parseInt(request.getParameter("user_id_send"));

		System.out.println("event update - " + eventid + " - " + name + " - " + date);

		tbl_event e = eventService.getOne(eventid);
		if (!name.equals("")) {
			e.setName(name);
		}
		if (!date.equals("")) {
			e.setDate(date);
		}
		if (!alterday.equals("")) {
			e.setAlterday(alterday);
		}
		if (!emoticon.equals("")) {
			e.setAlterday(emoticon.replace(API_PathHost.getLinkEmojis(), ""));
		}

		try {
			eventService.save(e);
			notificationService.saveData(user_id_send, api_EnumNotification.EDIT_EVENT.getMess());
			e.setEmoticon(emoticon);
			return new api_EventCreate(1, eventMessage(1), e);
		} catch (Exception e2) {
			return new api_EventCreate(2, eventMessage(2));
		}

	}

	@RequestMapping(value = "/eventdelete", method = RequestMethod.POST)
	public api_StatusAndMessage eventDelete(HttpServletRequest request, HttpServletResponse response, Model model) {

		String path = request.getServletContext().getRealPath("resources/images");

		int event_id = Integer.parseInt(request.getParameter("eventid"));
		int user_id_send = Integer.parseInt(request.getParameter("user_id_send"));

		System.out.println("event delete - " + event_id);

		try {
			eventService.delete(event_id);
			if (new API_File(path).deleteFile("event" + event_id)) {
				notificationService.saveData(user_id_send, api_EnumNotification.DELETE_EVENT.getMess());
				return new api_StatusAndMessage(1, eventMessage(1));
			} else {
				return new api_StatusAndMessage(2, eventMessage(2));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return new api_StatusAndMessage(2, eventMessage(2));
		}
	}

	@RequestMapping(value = "/testEvent", method = RequestMethod.POST)
	public String upLoadd() {
		return "asdasdsa";
	}

	public String eventMessage(int status) {
		if (status == 1) {
			return "Thành công";
		} else {
			return "Lỗi";
		}
	}
}
