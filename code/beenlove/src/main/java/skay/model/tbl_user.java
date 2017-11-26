package skay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class tbl_user {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;

	private String coupleid;
	private String username;
	private String pass;
	private String nickname;
	private String birth;
	private Integer gender;
	private String phone;
	private String ip;
	private String avatar;
	private String emoticon;

	public tbl_user() {
		super();
	}
	
	public tbl_user(tbl_user u) {
		super();
		this.userid = u.userid;
		this.coupleid = u.coupleid;
		this.username = u.username;
		this.nickname = u.nickname;
		this.birth = u.birth;
		this.gender = u.gender;
		this.phone = u.phone;
		this.ip = u.ip;
		this.avatar = u.avatar;
		this.emoticon = u.emoticon;
		this.pass = null;
	}

	public tbl_user(String coupleid, String username, String pass, String nickname, String birth, Integer gender,
			String phone, String ip, String avatar, String emoticon) {
		super();
		this.coupleid = coupleid;
		this.username = username;
		this.pass = pass;
		this.nickname = nickname;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.ip = ip;
		this.avatar = avatar;
		this.emoticon = emoticon;
	}

	public tbl_user(String coupleid, String username, String pass, String nickname, String birth, Integer gender,
			String phone, String avatar, String emoticon) {
		super();
		this.coupleid = coupleid;
		this.username = username;
		this.pass = pass;
		this.nickname = nickname;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.avatar = avatar;
		this.emoticon = emoticon;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getCoupleid() {
		return coupleid;
	}

	public void setCoupleid(String coupleid) {
		this.coupleid = coupleid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvata(String avatar) {
		this.avatar = avatar;
	}

	public String getEmoticon() {
		return emoticon;
	}

	public void setEmoticon(String emoticon) {
		this.emoticon = emoticon;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
