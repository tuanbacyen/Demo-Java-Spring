package skay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import skay.model.tbl_garelly;
import skay.myapi.API_PathHost;
import skay.repository.GarellyRepository;

@Service
@Transactional
public class GarellyService {
	@Autowired
	GarellyRepository garellyRepository;

	// get all

	// get all with Aniversarryid
	public List<tbl_garelly> findByAniversarryid(int aniversarryid) {
		String hostName = API_PathHost.getLinkGararellys();
		return garellyRepository.findByAniversarryidEndWith(hostName, aniversarryid);
	}

	// get only
	public tbl_garelly getOne(int id) {
		return garellyRepository.findOne(id);
	}
	
	// search by couple id

	// add
	public tbl_garelly save(tbl_garelly g) {
		return garellyRepository.save(g);
	}

	// delete
	public void delete(Integer aniversarryid) {
		garellyRepository.delete(aniversarryid);
	}

	// delete by aniversarryid
	public void deleteByAniversarryid(Integer aniversarryid) {
		garellyRepository.deleteByAniversarryid(aniversarryid);
	}

	// edit

}
