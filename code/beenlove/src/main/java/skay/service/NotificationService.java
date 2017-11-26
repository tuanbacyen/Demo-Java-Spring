package skay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skay.controller.API_DateTimeToString;
import skay.model.tbl_notification;
import skay.repository.NotificationRepository;
import skay.repository.UserRepository;

@Service
public class NotificationService {
	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	UserRepository userRepository;

	// get all
	public List<tbl_notification> getAllNotifi() {
		return (List<tbl_notification>) notificationRepository.findAll();
	}

	// add
	public boolean add(tbl_notification no) {
		try {
			notificationRepository.save(no);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	// get id user send
	public int findUserIdSend(int useridAction) {
		return Integer.parseInt(userRepository.findByUseridEndWith(useridAction));
	}

	public int findUserIdSend(int useridAction, String coupleid) {
		return Integer.parseInt(userRepository.findByUseridEndWith(useridAction));
	}

	// add with data
	public boolean saveData(int useridSend, String message) {
		try {
			tbl_notification no = new tbl_notification(findUserIdSend(useridSend), message,
					new API_DateTimeToString().getNowString());
			notificationRepository.save(no);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	// add with coupleid
	public boolean saveData(int userReceive, String coupleid, String message) {
		try {
			tbl_notification no = new tbl_notification(findUserIdSend(userReceive, coupleid), message,
					new API_DateTimeToString().getNowString());
			notificationRepository.save(no);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	// add with receiveid
	public boolean saveDataWithReceiveid(int receiveid, String message) {
		try {
			tbl_notification no = new tbl_notification(receiveid, message,
					new API_DateTimeToString().getNowString());
			notificationRepository.save(no);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
}
