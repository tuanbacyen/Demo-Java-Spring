package skay.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skay.model.api_Emoji;
import skay.model.listEmoji;
import skay.model.tbl_emoji_item;
import skay.model.tbl_group_emoji;
import skay.service.EmojiService;
import skay.service.GroupEmojiService;

@RestController
public class EmojiController {
	@Autowired
	EmojiService emojiService;
	@Autowired
	GroupEmojiService groupEmojiService;

	@RequestMapping(value = "/getemojis", method = RequestMethod.POST)
	public api_Emoji emoji(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		System.out.println("get all emoji");
		
		List<tbl_group_emoji> g = groupEmojiService.findAll();
		List<listEmoji> lstt = new ArrayList<listEmoji>();
		for (int i = 0; i < g.size(); i++) {
			List<tbl_emoji_item> e = emojiService.listEmoji(g.get(i).getGroupemojiid());
			listEmoji le = new listEmoji(g.get(i).getGroupemojiid(), g.get(i).getGroupemojiname(), e);
			lstt.add(le);
		}
		if (lstt.size() == 0) {
			return new api_Emoji(2, EMMessage(2), null);
		} else {
			return new api_Emoji(1, EMMessage(1), lstt);
		}
	}

	@RequestMapping(value = "/groupemoji", method = RequestMethod.POST)
	public List<tbl_group_emoji> groupemoji(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("group emoji api");
		return groupEmojiService.findAll();
	}

	public String EMMessage(int status) {
		if (status == 1) {
			return "Thành công";
		} else {
			return "Không có kết quả tìm kiếm";
		}
	}
}
