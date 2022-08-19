package com.hackathon.api.database.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.api.model.TableMatchScoreSummary;

public class TableMatchScoreSummaryRowMapper implements RowMapper<TableMatchScoreSummary>{

	private static final RowMapper<TableMatchScoreSummary> mostOfIt = new BeanPropertyRowMapper<>(TableMatchScoreSummary.class);
	private ObjectMapper objectMapper;

	public TableMatchScoreSummaryRowMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public TableMatchScoreSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
		TableMatchScoreSummary record = mostOfIt.mapRow(rs, rowNum);
		return record;

	}
}
