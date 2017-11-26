package skay.model;

import java.util.List;

public class api_Aniversarry {
	private int status;
	private String message;
	private int indexNext;
	private List<tbl_aniversarry> result;

	public api_Aniversarry() {
		super();
	}

	public api_Aniversarry(int status, String message, int indexNext, List<tbl_aniversarry> result) {
		super();
		this.status = status;
		this.message = message;
		this.indexNext = indexNext;
		this.result = result;
	}

	public api_Aniversarry(int status, String message, int indexNext) {
		super();
		this.status = status;
		this.message = message;
		this.indexNext = indexNext;
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

	public int getIndexNext() {
		return indexNext;
	}

	public void setIndexNext(int indexNext) {
		this.indexNext = indexNext;
	}

	public List<tbl_aniversarry> getResult() {
		return result;
	}

	public void setResult(List<tbl_aniversarry> result) {
		this.result = result;
	}

}
