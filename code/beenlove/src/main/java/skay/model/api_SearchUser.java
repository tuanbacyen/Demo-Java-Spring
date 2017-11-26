package skay.model;

import java.util.List;

public class api_SearchUser {
	private int status;
	private String message;
	private int indexNext;
	private List<tbl_user_search> result;

	public api_SearchUser(int status, String message, int indexNext, List<tbl_user_search> result) {
		super();
		this.status = status;
		this.message = message;
		this.indexNext = indexNext;
		this.result = result;
	}

	public api_SearchUser() {
		super();
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

	public List<tbl_user_search> getResult() {
		return result;
	}

	public void setResult(List<tbl_user_search> result) {
		this.result = result;
	}

}
