package skay.model;

import java.util.List;

public class api_AniversarryAdd {
	private int status;
	private String message;
	private List<tbl_garelly> result;

	public api_AniversarryAdd() {
		super();
	}

	public api_AniversarryAdd(int status, String message, List<tbl_garelly> result) {
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

	public List<tbl_garelly> getResult() {
		return result;
	}

	public void setResult(List<tbl_garelly> result) {
		this.result = result;
	}

}
