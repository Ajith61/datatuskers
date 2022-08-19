package com.hackathon.api.model;


public class TableSummary {

	private String rSchema;
	private String rTable;
	private String rColumnNames;
	private String rColumnsCount;
	private String rFullMatchCount;
	private String rSubSuperSetCount;
	private String rPartialMatchCount;
	public String getrSchema() {
		return rSchema;
	}
	public void setrSchema(String rSchema) {
		this.rSchema = rSchema;
	}
	public String getrTable() {
		return rTable;
	}
	public void setrTable(String rTable) {
		this.rTable = rTable;
	}
	public String getrColumnNames() {
		return rColumnNames;
	}
	public void setrColumnNames(String rColumnNames) {
		this.rColumnNames = rColumnNames;
	}
	public String getrColumnsCount() {
		return rColumnsCount;
	}
	public void setrColumnsCount(String rColumnsCount) {
		this.rColumnsCount = rColumnsCount;
	}
	public String getrFullMatchCount() {
		return rFullMatchCount;
	}
	public void setrFullMatchCount(String rFullMatchCount) {
		this.rFullMatchCount = rFullMatchCount;
	}
	public String getrSubSuperSetCount() {
		return rSubSuperSetCount;
	}
	public void setrSubSuperSetCount(String rSubSuperSetCount) {
		this.rSubSuperSetCount = rSubSuperSetCount;
	}
	public String getrPartialMatchCount() {
		return rPartialMatchCount;
	}
	public void setrPartialMatchCount(String rPartialMatchCount) {
		this.rPartialMatchCount = rPartialMatchCount;
	}

	
}
