package skay.model;

public enum api_EnumNotification {
	CREATE_EVENT("Một event mới đã được tạo!"), EDIT_EVENT("Một event đã chỉnh sửa!"), DELETE_EVENT(
			"Một event đã xóa!"), CREATE_ALBUM("Một album mới đã được tạo"), EDIT_ALBUM(
					"Một album đã chỉnh sửa!"), DELETE_ALBUM("Một album đã xóa!"), ADD_GARELLY(
							"Một vài bức ảnh đã được thêm vào album của bạn!"), DELETE_GARELLY(
									"Một vài bức ảnh đã được xóa bỏ khỏi album của bạn!"), HAVE_REQUEST_LOVE(
											"Có một lời mời kết đôi!"), CANCEL_REQUEST_LOVE(
													"Lời mời kết đôi của bạn bị hủy!"), SUCCESS_REQUEST_LOVE(
															"Bạn đã kết đôi thành công!");

	private String mess;

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	private api_EnumNotification(String mess) {
		this.mess = mess;
	}

}
