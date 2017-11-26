package skay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skay.model.tbl_user;
import skay.model.tbl_user_search;
import skay.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	// get all
	public Iterable<tbl_user> findAll() {
		return userRepository.findAll();
	}

	// login
	public List<tbl_user> login(String username, String pass) {
		return userRepository.findByUsernameAndPass(username, pass);
	}

	// search
	public List<tbl_user_search> findByUsernameEndWith(String username, int from, int to) {
		List<Object> lst = (List<Object>) userRepository.findByUsernameEndWith(username, from, to);
		List<tbl_user_search> lstUser = new ArrayList<tbl_user_search>();
		for (Object o : lst) {
			lstUser.add(new tbl_user_search(o));
		}
		return lstUser;
	}

	// find by user name
	public tbl_user CheckUserHave(String user) {
		return userRepository.findByUsername(user);
	}

	// find one
	public tbl_user findOne(int user_id) {
		return userRepository.findOne(user_id);
	}

	// save
	public void save(tbl_user u) {
		userRepository.save(u);
	}

	// delete
	public void delete(int user_id) {
		userRepository.delete(user_id);
	}

	// findone to save
	public Boolean findOneToSave(int id, String coupleid) {
		tbl_user u = userRepository.findOne(id);
		u.setCoupleid(coupleid);
		try {
			userRepository.save(u);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}

	}
}
