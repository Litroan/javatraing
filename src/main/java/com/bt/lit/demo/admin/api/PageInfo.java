package com.bt.lit.demo.admin.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageInfo {
	private int pageIndex = 1;
	private int pageSize = 10;
	private int totalRows;
	private int totalPages;
	private String sortColumn;
	private String sortType;

	public static PageInfo newInstance(int pageIndex, int pageSize, int totalRows) {
		PageInfo pageInfo = new PageInfo();
		int size = Integer.valueOf(pageSize);
		int index = Integer.valueOf(pageIndex);
		int rows = Integer.valueOf(totalRows);
		pageInfo.setPageSize(size);
		pageInfo.setTotalRows(totalRows);
		int pages = rows % pageSize != 0 ? rows / size + 1 : rows / size;
		pageInfo.setTotalPages(pages);
		pageInfo.setPageIndex(index > pages ? pages : index);
		return pageInfo;
	}
}
