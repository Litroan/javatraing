package com.bt.lit.demo.admin.api;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ====================================================================== <br>
 * Licensed Materials - Property of BlueTechnology Corp., Ltd. <br>
 * 藍科數位科技股份有限公司版權所有翻印必究 <br>
 * (C) Copyright BlueTechnology Corp., Ltd. 2019 All Rights Reserved. <br>
 * 日期：2020年7月8日<br>
 * 作者：Kent Huang<br>
 * 程式代號: BasicOut.java<br>
 * 程式說明: API統一輸出格式<br>
 * ======================================================================
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasicOut<T> {

	private String code = String.valueOf(CommonApiCode.SUCCESS.getCode());
	private String status = "s";
	private List<String> message;
	private T data;

	private PageInfo pageInfo;

	public void setCode(ApiCode code) {
		this.code = String.valueOf(code.getCode());
		if (message == null) {
			message = new ArrayList<String>();
		}
		this.message.add(code.getMessage());
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCode(int intCode) {
		this.code = String.valueOf(intCode);
	}

	public BasicOut(int pageIndex, int pageSize, int totalRows) {
		this.pageInfo = new PageInfo();
		this.pageInfo.setPageSize(pageSize);
		this.pageInfo.setTotalRows(totalRows);
		int totalPages = totalRows % pageSize != 0 ? totalRows / pageSize + 1 : totalRows / pageSize;
		this.pageInfo.setTotalPages(totalPages);
		this.pageInfo.setPageIndex(pageIndex > totalPages ? totalPages : pageIndex);
	}

	public void addMessage(String msg) {
		if (message == null) {
			message = new ArrayList<String>();
		}
		this.message.add(msg);
	}

}
