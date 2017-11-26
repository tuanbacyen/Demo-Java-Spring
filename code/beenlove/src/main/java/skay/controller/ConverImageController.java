package skay.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skay.model.api_ConverImage;
import skay.model.tbl_coverimage;
import skay.service.ConverImageService;

@RestController
public class ConverImageController {

	@Autowired
	ConverImageService converImageService;

	@RequestMapping(value = "/getconverimages", method = RequestMethod.POST)
	public api_ConverImage upLoadd(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			int type = Integer.parseInt(request.getParameter("type"));

			System.out.println("get conver images api - " + type);

			List<tbl_coverimage> lstCI = converImageService.getQuerry(type);
			if (lstCI.size() == 0) {
				return new api_ConverImage(2, CIMessage(2));
			} else {
				return new api_ConverImage(1, CIMessage(1), lstCI);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return new api_ConverImage(2, CIMessage(2));
		}
	}

	public String CIMessage(int status) {
		if (status == 1) {
			return "Thành công";
		} else {
			return "Không có kết quả";
		}
	}
}
