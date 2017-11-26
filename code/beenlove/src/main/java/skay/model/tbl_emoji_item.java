package skay.model;

public class tbl_emoji_item {
	private Integer emojiid;
	private String emojiname;
	private String emojiurl;

	public tbl_emoji_item(Integer emojiid, String emojiname, String emojiurl) {
		super();
		this.emojiid = emojiid;
		this.emojiname = emojiname;
		this.emojiurl = emojiurl;
	}

	public tbl_emoji_item() {
		super();
	}

	public tbl_emoji_item(tbl_emoji e) {
		super();
		this.emojiid = e.getEmojiid();
		this.emojiname = e.getEmojiname();
		this.emojiurl = e.getEmojiurl();
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

}
