package skay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skay.model.tbl_aniversarry;
import skay.repository.AniversarryRepository;

@Service
public class AniversarryService {
	@Autowired
	AniversarryRepository anivesarryRepository;

	public List<tbl_aniversarry> findByCoupleidEndWith(String coupleid, int from, int to) {
		String hostName = "http://192.168.2.48:8080/resources/converimages/";
		
		System.out.println(coupleid + " == " + from + " == " + to);
		return anivesarryRepository.findByCoupleidEndWith(hostName, coupleid, from, to);
	}
	
	// get one
	public tbl_aniversarry getOne(int id) {
		return anivesarryRepository.findOne(id);
	}
	
	// save
	public tbl_aniversarry save(tbl_aniversarry a) {
		return anivesarryRepository.save(a);
	}
	
	// delete
	public void delete(Integer anivesarry_id) {
		anivesarryRepository.delete(anivesarry_id);
	}
}
