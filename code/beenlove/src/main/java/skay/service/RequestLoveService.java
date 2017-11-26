package skay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import skay.model.tbl_request_love;
import skay.repository.RequestLoveRepository;

@Service
@Transactional
public class RequestLoveService {
	@Autowired
	RequestLoveRepository requestLoveRepository;

	// create
	public tbl_request_love create(tbl_request_love rl) {
		return requestLoveRepository.save(rl);
	}
	
	// save
	public void save(tbl_request_love rl) {
		requestLoveRepository.save(rl);
	}
	
	// find to edit
	public tbl_request_love findToEdit(int senderid, int receiveid) {
		return requestLoveRepository.findBySenderidAndReceiveidEndWith(senderid, receiveid);
	}
	
	// find One
	public tbl_request_love findOne(int id) {
		return requestLoveRepository.findOne(id);
	}
	
	// delete
	public void delete(int id) {
		requestLoveRepository.delete(id);
	}
}
