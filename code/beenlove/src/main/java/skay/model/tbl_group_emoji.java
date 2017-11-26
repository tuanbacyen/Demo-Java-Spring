package skay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_group_emoji")
public class tbl_group_emoji {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "group_emoji_id")
	private Integer groupemojiid;

	@Column(name = "group_emoji_name")
	private String groupemojiname;

	public tbl_group_emoji() {
		super();
	}

	public tbl_group_emoji(String groupemojiname) {
		super();
		this.groupemojiname = groupemojiname;
	}

	public tbl_group_emoji(Integer groupemojiid, String groupemojiname) {
		super();
		this.groupemojiid = groupemojiid;
		this.groupemojiname = groupemojiname;
	}

	public Integer getGroupemojiid() {
		return groupemojiid;
	}

	public void setGroupemojiid(Integer groupemojiid) {
		this.groupemojiid = groupemojiid;
	}

	public String getGroupemojiname() {
		return groupemojiname;
	}

	public void setGroupemojiname(String groupemojiname) {
		this.groupemojiname = groupemojiname;
	}

}
