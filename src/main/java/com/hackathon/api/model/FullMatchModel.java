package com.hackathon.api.model;

public class FullMatchModel {
	
	private String rSrcSchema;
	private String rSrcTable;
	private String rDestSchema;
	private String rDestTable;
	private String rSrcCount;
	private String rDestCount;
	private String rMatchCount;
	private String rTotalScore;

	public String getrSrcSchema() {
		return rSrcSchema;
	}

	public void setrSrcSchema(String rSrcSchema) {
		this.rSrcSchema = rSrcSchema;
	}

	public String getrSrcTable() {
		return rSrcTable;
	}

	public void setrSrcTable(String rSrcTable) {
		this.rSrcTable = rSrcTable;
	}

	public String getrDestSchema() {
		return rDestSchema;
	}

	public void setrDestSchema(String rDestSchema) {
		this.rDestSchema = rDestSchema;
	}

	public String getrDestTable() {
		return rDestTable;
	}

	public void setrDestTable(String rDestTable) {
		this.rDestTable = rDestTable;
	}

	public String getrSrcCount() {
		return rSrcCount;
	}

	public void setrSrcCount(String rSrcCount) {
		this.rSrcCount = rSrcCount;
	}

	public String getrDestCount() {
		return rDestCount;
	}

	public void setrDestCount(String rDestCount) {
		this.rDestCount = rDestCount;
	}

	public String getrMatchCount() {
		return rMatchCount;
	}

	public void setrMatchCount(String rMatchCount) {
		this.rMatchCount = rMatchCount;
	}

	public String getrTotalScore() {
		return rTotalScore;
	}

	public void setrTotalScore(String rTotalScore) {
		this.rTotalScore = rTotalScore;
	}
	
	

}
