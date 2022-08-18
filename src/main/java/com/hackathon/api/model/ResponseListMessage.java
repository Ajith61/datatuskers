package com.hackathon.api.model;

import java.util.List;

public class ResponseListMessage {
	
	private String message;
	private List<DataTable> datas;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<DataTable> getDatas() {
		return datas;
	}
	public void setDatas(List<DataTable> datas) {
		this.datas = datas;
	}
	public ResponseListMessage(String message, List<DataTable> datas) {
		super();
		this.message = message;
		this.datas = datas;
	}
	
	
}
