package skay.model;

import java.util.List;

public class api_Event {
	private int status;
	private String message;
	private int indexNext;
	private List<tbl_event> result;

	public api_Event() {
		super();
	}

	public api_Event(int status, String message, int indexNext, List<tbl_event> result) {
		super();
		this.status = status;
		this.message = message;
		this.indexNext = indexNext;
		this.result = result;
	}

	public api_Event(int status, String message, int indexNext) {
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

	public List<tbl_event> getResult() {
		return result;
	}

	public void setResult(List<tbl_event> result) {
		this.result = result;
	}

}
