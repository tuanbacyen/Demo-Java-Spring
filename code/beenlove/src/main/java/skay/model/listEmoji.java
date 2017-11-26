package skay.model;

import java.util.List;

public class listEmoji {
	private int id;
	private String name;
	private List<tbl_emoji_item> item;

	public listEmoji() {
		super();
	}

	public listEmoji(int id, String name, List<tbl_emoji_item> item) {
		super();
		this.id = id;
		this.name = name;
		this.item = item;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<tbl_emoji_item> getItem() {
		return item;
	}

	public void setItem(List<tbl_emoji_item> item) {
		this.item = item;
	}

}
