package skay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skay.model.tbl_coverimage;
import skay.myapi.API_PathHost;
import skay.repository.ConverImageRepository;

@Service
public class ConverImageService {
	@Autowired
	ConverImageRepository converImageRepository;

	// get all converimages
	public List<tbl_coverimage> getConverImages(int type) {
		return converImageRepository.findByCoverimagetype(type);
	}

	public List<tbl_coverimage> getQuerry(int type) {
		String hostName = "";
		if (type == 1) {
			hostName = API_PathHost.getLinkConvers();
		} else if (type == 2) {
			hostName = API_PathHost.getLinkBackgrounds();
		}
		return converImageRepository.findByCoverimagetypeEndWith(hostName, type);
	}

	// get one
	public tbl_coverimage getOne(int id) {
		return converImageRepository.findOne(id);
	}
	// add

	// delete

	// update
}
