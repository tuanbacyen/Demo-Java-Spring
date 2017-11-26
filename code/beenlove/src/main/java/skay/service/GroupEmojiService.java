package skay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skay.model.tbl_group_emoji;
import skay.repository.GroupEmojiRepository;

@Service
public class GroupEmojiService {
	@Autowired
	GroupEmojiRepository groupEmojiRepository;
	
	public List<tbl_group_emoji> findAll(){
		return (List<tbl_group_emoji>) groupEmojiRepository.findAll();
	}
}
