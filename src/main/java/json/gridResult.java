package json;

import java.util.List;

public class gridResult {
	private int totalRow;
	private List<data> list;

	private int totalPage;
	private int pageSize;

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
	public List<data> getList() {
		return list;
	}
	public void setList(List<data> list) {
		this.list = list;
	}
}
