package com.hackathon.api.model;

public class TableMatchColumnSummary {

	private String rMatchedColumn;
	private String rUnmatchedSrcColumn;
	private String rUnmatchedDestColumn;
	public String getrMatchedColumn() {
		return rMatchedColumn;
	}
	public void setrMatchedColumn(String rMatchedColumn) {
		this.rMatchedColumn = rMatchedColumn;
	}
	public String getrUnmatchedSrcColumn() {
		return rUnmatchedSrcColumn;
	}
	public void setrUnmatchedSrcColumn(String rUnmatchedSrcColumn) {
		this.rUnmatchedSrcColumn = rUnmatchedSrcColumn;
	}
	public String getrUnmatchedDestColumn() {
		return rUnmatchedDestColumn;
	}
	public void setrUnmatchedDestColumn(String rUnmatchedDestColumn) {
		this.rUnmatchedDestColumn = rUnmatchedDestColumn;
	}

	
}
