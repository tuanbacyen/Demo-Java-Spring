package skay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import skay.model.tbl_event;
import skay.myapi.API_PathHost;
import skay.repository.EventRepository;

@Service
@Transactional
public class EventService {
	@Autowired
	EventRepository eventRepository;

	// getall

	// get all with couple id
	public List<tbl_event> getAllWithCoupleId(String coupleid, int from, int to) {
		return eventRepository.findByCoupleidEndWith(API_PathHost.getLinkEmojis(), coupleid, from, to);
	}

	// get one
	public tbl_event getOne(int id) {
		return eventRepository.findOne(id);
	}

	// add
	public Boolean save(tbl_event ev) {
		try {
			eventRepository.save(ev);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	// delete
	public void delete(int id) {
		eventRepository.delete(id);
	}

	// update

}
