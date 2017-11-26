package skay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_notification")
public class tbl_notification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "notifi_id")
	private int notifiid;

	@Column(name = "userid_send")
	private int useridsend;

	private String message;
	private String datetime;

	public tbl_notification() {
		super();
	}

	public tbl_notification(int useridsend, String message, String datetime) {
		super();
		this.useridsend = useridsend;
		this.message = message;
		this.datetime = datetime;
	}

	public tbl_notification(int notifiid, int useridsend, String message, String datetime) {
		super();
		this.notifiid = notifiid;
		this.useridsend = useridsend;
		this.message = message;
		this.datetime = datetime;
	}

	public int getNotifiid() {
		return notifiid;
	}

	public void setNotifiid(int notifiid) {
		this.notifiid = notifiid;
	}

	public int getUseridsend() {
		return useridsend;
	}

	public void setUseridsend(int useridsend) {
		this.useridsend = useridsend;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}
