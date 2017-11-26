package skay.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_chatbox")
public class tbl_chatbox {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer chat_id;
	
	private String couple_id;
	private Integer sender_id;
	private Integer receive_id;
	private String messenger;
	private Date date;
	
	public tbl_chatbox() {
		super();
	}

	public tbl_chatbox(Integer chat_id, String couple_id, Integer sender_id, Integer receive_id, String messenger,
			Date date) {
		super();
		this.chat_id = chat_id;
		this.couple_id = couple_id;
		this.sender_id = sender_id;
		this.receive_id = receive_id;
		this.messenger = messenger;
		this.date = date;
	}

	public Integer getChat_id() {
		return chat_id;
	}

	public void setChat_id(Integer chat_id) {
		this.chat_id = chat_id;
	}

	public String getCouple_id() {
		return couple_id;
	}

	public void setCouple_id(String couple_id) {
		this.couple_id = couple_id;
	}

	public Integer getSender_id() {
		return sender_id;
	}

	public void setSender_id(Integer sender_id) {
		this.sender_id = sender_id;
	}

	public Integer getReceive_id() {
		return receive_id;
	}

	public void setReceive_id(Integer receive_id) {
		this.receive_id = receive_id;
	}

	public String getMessenger() {
		return messenger;
	}

	public void setMessenger(String messenger) {
		this.messenger = messenger;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
