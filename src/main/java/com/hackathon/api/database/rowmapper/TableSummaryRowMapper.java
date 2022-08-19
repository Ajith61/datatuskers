package com.hackathon.api.database.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.api.model.TableSummary;

public class TableSummaryRowMapper implements RowMapper<TableSummary>{

	private static final RowMapper<TableSummary> mostOfIt = new BeanPropertyRowMapper<>(TableSummary.class);
	private ObjectMapper objectMapper;

	public TableSummaryRowMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public TableSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
		TableSummary record = mostOfIt.mapRow(rs, rowNum);
		return record;

	}
}
