package skay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_event")
public class tbl_event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eventid;

	private String coupleid;
	private String name;
	private String date;
	private String alterday;
	private String emoticon;

	public tbl_event() {
		super();
	}

	public tbl_event(String coupleid, String name, String date, String alterday, String emoticon) {
		super();
		this.coupleid = coupleid;
		this.name = name;
		this.date = date;
		this.alterday = alterday;
		this.emoticon = emoticon;
	}

	public tbl_event(Integer eventid, String coupleid, String name, String date, String alterday, String emoticon) {
		super();
		this.eventid = eventid;
		this.coupleid = coupleid;
		this.name = name;
		this.date = date;
		this.alterday = alterday;
		this.emoticon = emoticon;
	}

	public Integer getEventid() {
		return eventid;
	}

	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	public String getCoupleid() {
		return coupleid;
	}

	public void setCoupleid(String coupleid) {
		this.coupleid = coupleid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAlterday() {
		return alterday;
	}

	public void setAlterday(String alterday) {
		this.alterday = alterday;
	}

	public String getEmoticon() {
		return emoticon;
	}

	public void setEmoticon(String emoticon) {
		this.emoticon = emoticon;
	}

}
