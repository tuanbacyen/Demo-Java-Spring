package skay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_request_love")
public class tbl_request_love {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer requestloveid;

	private Integer senderid;
	private Integer receiveid;
	private String state;

	public tbl_request_love() {
		super();
	}

	public tbl_request_love(Integer requestloveid, Integer senderid, Integer receiveid, String state) {
		super();
		this.requestloveid = requestloveid;
		this.senderid = senderid;
		this.receiveid = receiveid;
		this.state = state;
	}
	

	public tbl_request_love(Integer senderid, Integer receiveid, String state) {
		super();
		this.senderid = senderid;
		this.receiveid = receiveid;
		this.state = state;
	}

	public Integer getRequestloveid() {
		return requestloveid;
	}

	public void setRequestloveid(Integer requestloveid) {
		this.requestloveid = requestloveid;
	}

	public Integer getSenderid() {
		return senderid;
	}

	public void setSenderid(Integer senderid) {
		this.senderid = senderid;
	}

	public Integer getReceiveid() {
		return receiveid;
	}

	public void setReceiveid(Integer receiveid) {
		this.receiveid = receiveid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
