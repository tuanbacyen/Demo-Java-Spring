package skay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_emoji")
public class tbl_emoji {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emoji_id")
	private Integer emojiid;

	@Column(name = "emoji_name")
	private String emojiname;

	@Column(name = "emoji_url")
	private String emojiurl;

	@Column(name = "group_emoji_id")
	private Integer groupemojiid;

	public tbl_emoji() {
		super();
	}

	public tbl_emoji(String emojiname, String emojiurl, Integer groupemojiid) {
		super();
		this.emojiname = emojiname;
		this.emojiurl = emojiurl;
		this.groupemojiid = groupemojiid;
	}

	public tbl_emoji(Integer emojiid, String emojiname, String emojiurl, Integer groupemojiid) {
		super();
		this.emojiid = emojiid;
		this.emojiname = emojiname;
		this.emojiurl = emojiurl;
		this.groupemojiid = groupemojiid;
	}

	public Integer getEmojiid() {
		return emojiid;
	}

	public void setEmojiid(Integer emojiid) {
		this.emojiid = emojiid;
	}

	public String getEmojiname() {
		return emojiname;
	}

	public void setEmojiname(String emojiname) {
		this.emojiname = emojiname;
	}

	public String getEmojiurl() {
		return emojiurl;
	}

	public void setEmojiurl(String emojiurl) {
		this.emojiurl = emojiurl;
	}

	public Integer getGroupemojiid() {
		return groupemojiid;
	}

	public void setGroupemojiid(Integer groupemojiid) {
		this.groupemojiid = groupemojiid;
	}
}
