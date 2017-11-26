package skay.model;

public class api_AniversarryCreate {
	private int status;
	private String message;
	private tbl_aniversarry result;

	public api_AniversarryCreate() {
		super();
	}

	public api_AniversarryCreate(int status, String message, tbl_aniversarry result) {
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

	public tbl_aniversarry getResult() {
		return result;
	}

	public void setResult(tbl_aniversarry result) {
		this.result = result;
	}
}
