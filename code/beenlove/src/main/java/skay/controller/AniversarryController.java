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

import skay.model.api_AniversarryAdd;
import skay.model.api_AniversarryDelete;
import skay.model.api_AniversarryDetail;
import skay.model.api_EnumNotification;
import skay.model.api_Aniversarry;
import skay.model.api_AniversarryCreate;
import skay.model.tbl_aniversarry;
import skay.model.tbl_garelly;
import skay.service.AniversarryService;
import skay.service.ConverImageService;
import skay.service.GarellyService;
import skay.service.NotificationService;

@RestController
public class AniversarryController {
	@Autowired
	AniversarryService aniversarryService;

	@Autowired
	GarellyService garellyService;

	@Autowired
	ConverImageService converImageService;

	@Autowired
	NotificationService notificationService;

	String pathSaveImage = "resources/images";

	@RequestMapping(value = "/aniversarry", method = RequestMethod.POST)
	public api_Aniversarry aniversarryWithParam(HttpServletRequest request, HttpServletResponse response, Model model) {
		// get param
		String coupleid = request.getParameter("coupleid");
		String index = request.getParameter("index");
		String limit = request.getParameter("limit");

		// value
		System.out.print("aniversarry api" + coupleid + " - " + index + " - " + limit + "\n");

		API_PageCustom page = new API_PageCustom(index, limit);

		List<tbl_aniversarry> result = aniversarryService.findByCoupleidEndWith(coupleid, page.fromLimit(),
				page.toLimit());

		int indexNext = page.indexNext(result.size(), index);

		if (indexNext != -1) {
			result.remove(result.size() - 1);
		}
		if (result.size() == 0 || result == null) {
			return new api_Aniversarry(2, AMessage(2), indexNext, null);
		} else {
			return new api_Aniversarry(1, AMessage(1), indexNext, result);
		}
	}

	@RequestMapping(value = "/aniversarrycreate", method = RequestMethod.POST)
	public api_AniversarryCreate aniversarryCreate(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		// get param
		String coupleid = request.getParameter("coupleid");
		String name = request.getParameter("name");
		String detail = request.getParameter("detail");
		String date = request.getParameter("date");
		String urlimage = request.getParameter("urlimage");
		int user_id_send = Integer.parseInt(request.getParameter("user_id_send"));

		System.out.print(
				"aniversarry create api" + coupleid + " - " + name + " - " + detail + " - " + date + "- " + urlimage);

		tbl_aniversarry a = new tbl_aniversarry(coupleid, name, detail, date, urlimage);

		try {
			aniversarryService.save(a);
			notificationService.saveData(user_id_send, coupleid, api_EnumNotification.CREATE_ALBUM.getMess());
			return new api_AniversarryCreate(1, AMessage(1), a);
		} catch (Exception e) {
			return new api_AniversarryCreate(2, AMessage(2), null);
		}
	}

	@RequestMapping(value = "/aniversarryupdate", method = RequestMethod.POST)
	public api_AniversarryCreate aniversarryUpdate(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		// get param
		int aniversarryid = Integer.parseInt(request.getParameter("aniversarryid"));
		String name = request.getParameter("name");
		String detail = request.getParameter("detail");
		String date = request.getParameter("date");
		String urlimage = request.getParameter("urlimage");
		int user_id_send = Integer.parseInt(request.getParameter("user_id_send"));

		System.out.print("aniversarry create api" + aniversarryid + " - " + name + " - " + detail + " - " + date + "- "
				+ urlimage);

		tbl_aniversarry a = aniversarryService.getOne(aniversarryid);

		try {
			if (!name.equals("") && name != null) {
				a.setName(name);
			}
			if (!date.equals("") && date != null) {
				a.setDate(name);
			}
			if (!urlimage.equals("") && urlimage != null) {
				a.setUrlimage(urlimage);
			}
			if (!detail.equals("") && detail != null) {
				a.setDetail(detail);
			}
			aniversarryService.save(a);
			notificationService.saveData(user_id_send, api_EnumNotification.EDIT_ALBUM.getMess());
			return new api_AniversarryCreate(1, AMessage(1), a);
		} catch (Exception e) {
			return new api_AniversarryCreate(2, AMessage(2), null);
		}
	}

	@RequestMapping(value = "/aniversarryadd", method = RequestMethod.POST)
	public api_AniversarryAdd aniversarryAdd(@RequestParam("listimage") List<MultipartFile> files,
			@RequestParam("aniversarryid") Integer aniversarryid, @RequestParam("user_id_send") Integer user_id_send,
			HttpServletRequest request) {

		System.out.print("aniversarry add api" + aniversarryid);

		String path = request.getServletContext().getRealPath(pathSaveImage);

		tbl_aniversarry a = aniversarryService.getOne(aniversarryid);

		System.out.println(a.getCoupleid());

		if (files.size() == 0 || files == null) {
			return new api_AniversarryAdd(2, AMessage(2), null);
		} else {

			List<tbl_garelly> lstGarelly = garellyService.findByAniversarryid(aniversarryid);

			for (int i = 0; i < files.size(); i++) {
				tbl_garelly g = new tbl_garelly(a.getCoupleid(), aniversarryid, "google.com.vn");
				garellyService.save(g);

				String fileName = new API_File(path).saveFileWithName(files.get(i),
						aniversarryid.toString() + "_" + g.getGarellyid());
				if (fileName.equals("fail")) {
					return new api_AniversarryAdd(2, AMessage(2), null);
				} else {
					g.setUrlimage(fileName);
					garellyService.save(g);
					lstGarelly.add(new tbl_garelly(g));
				}
			}
			notificationService.saveData(user_id_send, api_EnumNotification.ADD_GARELLY.getMess());
			return new api_AniversarryAdd(1, AMessage(1), lstGarelly);
		}
	}

	@RequestMapping(value = "/aniversarrydelete", method = RequestMethod.POST)
	public api_AniversarryDelete aniversarryDelete(HttpServletRequest request, HttpServletResponse response,
			Model model) {

		String path = request.getServletContext().getRealPath(pathSaveImage);

		// get param
		Integer aniversarry_id = Integer.parseInt(request.getParameter("aniversarry_id"));
		int user_id_send = Integer.parseInt(request.getParameter("user_id_send"));

		System.out.println("aniversarry delete - " + aniversarry_id);

		try {
			aniversarryService.delete(aniversarry_id);
			garellyService.deleteByAniversarryid(aniversarry_id);
			if (new API_File(path).deleteFile(aniversarry_id.toString())) {
				notificationService.saveData(user_id_send, api_EnumNotification.DELETE_ALBUM.getMess());
				return new api_AniversarryDelete(1, AMessage(1));
			} else {
				return new api_AniversarryDelete(2, AMessage(2));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return new api_AniversarryDelete(2, AMessage(2));
		}
	}

	@RequestMapping(value = "/aniversarrydetail", method = RequestMethod.POST)
	public api_AniversarryDetail aniversarryDetail(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		
		Integer aniversarryid = Integer.parseInt(request.getParameter("aniversarryid"));
		
		System.out.println("aniversarry detail - " + aniversarryid);

		List<tbl_garelly> temp = garellyService.findByAniversarryid(aniversarryid);
		if (temp.size() == 0) {
			return new api_AniversarryDetail(2, AMessage(2));
		} else {
			return new api_AniversarryDetail(1, AMessage(1), temp);
		}
	}

	@RequestMapping(value = "/testA", method = RequestMethod.POST)
	public String upLoadd() {
		return "hiahida";
	}

	public String AMessage(int status) {
		if (status == 1) {
			return "Thành công";
		} else {
			return "Lỗi";
		}
	}
}
