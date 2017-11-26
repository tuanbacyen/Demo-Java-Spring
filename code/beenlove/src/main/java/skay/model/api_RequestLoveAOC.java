package skay.model;

public class api_RequestLoveAOC {
	private int status;
	private String message;
	private tbl_request_love result;

	public api_RequestLoveAOC() {
		super();
	}

	public api_RequestLoveAOC(int status, String message, tbl_request_love result) {
		super();
		this.status = status;
		this.message = message;
		this.result = result;
	}

	public api_RequestLoveAOC(int status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.result = null;
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

	public tbl_request_love getResult() {
		return result;
	}

	public void setResult(tbl_request_love result) {
		this.result = result;
	}

}
