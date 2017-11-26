package skay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skay.model.tbl_emoji;
import skay.model.tbl_emoji_item;
import skay.myapi.API_PathHost;
import skay.repository.EmojiRepository;

@Service
public class EmojiService {
	@Autowired
	EmojiRepository emojiRepository;

	String hostEmoji = API_PathHost.getLinkEmojis();

	// get all with group id
	public List<tbl_emoji> findByCoverimagetypeEndWith(int groupid) {
		return emojiRepository.findByGroupemojiidEndWith(hostEmoji, groupid);
	}

	public List<tbl_emoji_item> listEmoji(int groupid) {
		List<tbl_emoji> lst = emojiRepository.findByGroupemojiidEndWith(hostEmoji, groupid);
		List<tbl_emoji_item> lstItem = new ArrayList<tbl_emoji_item>();
		for (tbl_emoji emoji : lst) {
			lstItem.add(new tbl_emoji_item(emoji));
		}
		return lstItem;
	}
}
