package com.hackathon.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "datatable")
public class DataTable {

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "schema")
	private String schema;

	@Column(name = "table_name")
	private String tableName;

	@Column(name = "column_name")
	private String columnName;

	public long getId() {
		return id;
	}

	public DataTable() {
		super();
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public DataTable( String schema, String tableName, String columnName) {
		super();
		this.schema = schema;
		this.tableName = tableName;
		this.columnName = columnName;
	}

	@Override
	public String toString() {
		return "DataTable [id=" + id + ", schema=" + schema + ", tableName=" + tableName + ", columnName=" + columnName
				+ "]";
	}

}
