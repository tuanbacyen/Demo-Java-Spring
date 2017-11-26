package skay.model;

import java.util.List;

public class api_ConverImage {
	private int status;
	private String message;
	private List<tbl_coverimage> result;

	public api_ConverImage() {
		super();
	}

	public api_ConverImage(int status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.result = null;
	}

	public api_ConverImage(int status, String message, List<tbl_coverimage> result) {
		super();
		this.status = status;
		this.message = message;
		this.result = result;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<tbl_coverimage> getResult() {
		return result;
	}

	public void setResult(List<tbl_coverimage> result) {
		this.result = result;
	}

}
