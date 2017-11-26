package skay.model;

public class api_Register {
	private int status;
	private String message;
	private tbl_user result;

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

	public tbl_user getResult() {
		return result;
	}

	public void setResult(tbl_user result) {
		this.result = result;
	}

	public api_Register(int status, String message, tbl_user result) {
		super();
		this.status = status;
		this.message = message;
		this.result = new tbl_user(result);
	}

	public api_Register() {
		super();
	}

	public api_Register(int status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.result = null;
	}
	
}
