package skay.model;

public class tbl_user_search {

	private Integer userid;
	private String username;
	private String nickname;
	private String avatar;
	private String state;
	private String emoticon;

	public tbl_user_search() {
		super();
	}

	public tbl_user_search(Object o) {
		super();
		Object[] row = (Object[]) o;
		this.userid = Integer.parseInt(row[0].toString());
		this.username = row[1].toString();
		this.nickname = row[2].toString();
		this.avatar = row[3].toString();
		if(row[4] == null) {
			this.state = null;
		}else {
			this.state = row[4].toString();
		}
		this.emoticon = row[5].toString();
		System.out.println("");
	}
	
	public tbl_user_search(Integer userid, String username, String nickname, String avatar, String state, String emoticon) {
		super();
		this.userid = userid;
		this.username = username;
		this.nickname = nickname;
		this.avatar = avatar;
		this.state = state;
		this.emoticon = emoticon;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmoticon() {
		return emoticon;
	}

	public void setEmoticon(String emoticon) {
		this.emoticon = emoticon;
	}
}
