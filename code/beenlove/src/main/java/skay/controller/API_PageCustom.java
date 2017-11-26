package skay.controller;

public class API_PageCustom {

	private final int maxItemRequest = 500;
	private final int defaultItemLimit = 50;

	private int index;
	private int itemLimit;

	public API_PageCustom(String index, String limit) {
		super();

		if (index == null || index.equals("0") || index.equals("")) {
			this.index = 0;
		} else {
			this.index = Integer.parseInt(index);
		}

		if (limit == null || limit.equals("0") || limit.equals("")) {
			this.itemLimit = defaultItemLimit;
		} else {
			this.itemLimit = Integer.parseInt(limit);
		}
		if (this.itemLimit > maxItemRequest) {
			this.itemLimit = maxItemRequest;
		}
	}

	public int fromLimit() {
		int from = toLimit() - itemLimit;
		if (from == 0 || index == 0 || index == 1) {
			return 0;
		}
		return from;
	}

	public int toLimit() {
		int to = index * itemLimit;
		if (index == 0) {
			return itemLimit;
		}
		return to;
	}

	public int indexNext(int size, String index) {
		int indexNext = -1;
		if (size > this.getItemLimit()) {
			indexNext = Integer.parseInt(index) + 1;
		} else {
			indexNext = -1;
		}
		return indexNext;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getItemLimit() {
		return itemLimit;
	}

	public void setItemLimit(int itemLimit) {
		this.itemLimit = itemLimit;
	}

}
