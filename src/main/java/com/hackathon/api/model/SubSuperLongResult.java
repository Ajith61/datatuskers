package com.hackathon.api.model;

public class SubSuperLongResult {

	private String rSubsetSchema;
	private String rSubsetTable;
	private String rSupersetSchema;
	private String rSupersetTable;
	private String matchRatio;
	private String rIsWithinSameSchema;
	private String rIsTableNameSame;
	
	
	public String getrSubsetSchema() {
		return rSubsetSchema;
	}
	public void setrSubsetSchema(String rSubsetSchema) {
		this.rSubsetSchema = rSubsetSchema;
	}
	public String getrSubsetTable() {
		return rSubsetTable;
	}
	public void setrSubsetTable(String rSubsetTable) {
		this.rSubsetTable = rSubsetTable;
	}
	public String getrSupersetSchema() {
		return rSupersetSchema;
	}
	public void setrSupersetSchema(String rSupersetSchema) {
		this.rSupersetSchema = rSupersetSchema;
	}
	public String getrSupersetTable() {
		return rSupersetTable;
	}
	public void setrSupersetTable(String rSupersetTable) {
		this.rSupersetTable = rSupersetTable;
	}
	public String getMatchRatio() {
		return matchRatio;
	}
	public void setMatchRatio(String matchRatio) {
		this.matchRatio = matchRatio;
	}
	public String getrIsWithinSameSchema() {
		return rIsWithinSameSchema;
	}
	public void setrIsWithinSameSchema(String rIsWithinSameSchema) {
		this.rIsWithinSameSchema = rIsWithinSameSchema;
	}
	public String getrIsTableNameSame() {
		return rIsTableNameSame;
	}
	public void setrIsTableNameSame(String rIsTableNameSame) {
		this.rIsTableNameSame = rIsTableNameSame;
	}
	
	

	
}
