package skay.model;

public class api_Login {
	private int status;
	private String message;
	private tbl_user user;
	private tbl_user lover;
	
	public api_Login() {
		super();
	}
	
	public api_Login(int status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.user = null;
		this.lover = null;
	}

	public api_Login(int status, String message, tbl_user user, tbl_user lover) {
		super();
		this.status = status;
		this.message = message;
		this.user = new tbl_user(user);
		this.lover = lover;
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

	public tbl_user getUser() {
		return user;
	}

	public void setUser(tbl_user user) {
		this.user = user;
	}

	public tbl_user getLover() {
		return lover;
	}

	public void setLover(tbl_user lover) {
		this.lover = lover;
	}
}
