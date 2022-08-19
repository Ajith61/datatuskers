package com.hackathon.api.database.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.api.model.TableMatchColumnSummary;

public class TableMatchColumnSummaryRowMapper implements RowMapper<TableMatchColumnSummary>{

	private static final RowMapper<TableMatchColumnSummary> mostOfIt = new BeanPropertyRowMapper<>(TableMatchColumnSummary.class);
	private ObjectMapper objectMapper;

	public TableMatchColumnSummaryRowMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public TableMatchColumnSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
		TableMatchColumnSummary record = mostOfIt.mapRow(rs, rowNum);
		return record;

	}
}
