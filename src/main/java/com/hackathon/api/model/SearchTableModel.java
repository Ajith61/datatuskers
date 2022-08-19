package com.hackathon.api.model;

public class SearchTableModel {
	
	private String rSchema;
	private String rTableName;
	private String rColumnNames;
	public String getrSchema() {
		return rSchema;
	}
	public void setrSchema(String rSchema) {
		this.rSchema = rSchema;
	}
	public String getrTableName() {
		return rTableName;
	}
	public void setrTableName(String rTableName) {
		this.rTableName = rTableName;
	}
	public String getrColumnNames() {
		return rColumnNames;
	}
	public void setrColumnNames(String rColumnNames) {
		this.rColumnNames = rColumnNames;
	}
	
	

}
