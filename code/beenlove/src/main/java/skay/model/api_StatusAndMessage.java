package skay.model;

public class api_StatusAndMessage {
	private int status;
	private String message;

	public api_StatusAndMessage() {
		super();
	}

	public api_StatusAndMessage(int status, String message) {
		super();
		this.status = status;
		this.message = message;
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

}
