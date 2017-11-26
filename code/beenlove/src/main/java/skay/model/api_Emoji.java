package skay.model;

import java.util.List;

public class api_Emoji {
	private int status;
	private String message;
	private List<listEmoji> result;

	public api_Emoji() {
		super();
	}

	public api_Emoji(int status, String message, List<listEmoji> result) {
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

	public List<listEmoji> getResult() {
		return result;
	}

	public void setResult(List<listEmoji> result) {
		this.result = result;
	}

}