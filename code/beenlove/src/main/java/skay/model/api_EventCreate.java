package skay.model;

public class api_EventCreate {
	private int status;
	private String message;
	private tbl_event result;

	public api_EventCreate() {
		super();
	}

	public api_EventCreate(int status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.result = null;
	}

	public api_EventCreate(int status, String message, tbl_event result) {
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

	public tbl_event getResult() {
		return result;
	}

	public void setResult(tbl_event result) {
		this.result = result;
	}

}
