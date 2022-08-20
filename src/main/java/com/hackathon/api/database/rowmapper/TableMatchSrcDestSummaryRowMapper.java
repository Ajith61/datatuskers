package com.hackathon.api.database.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.api.model.TableMatchSrcDestSummary;

public class TableMatchSrcDestSummaryRowMapper implements RowMapper<TableMatchSrcDestSummary>{

	private static final RowMapper<TableMatchSrcDestSummary> mostOfIt = new BeanPropertyRowMapper<>(TableMatchSrcDestSummary.class);
	private ObjectMapper objectMapper;

	public TableMatchSrcDestSummaryRowMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public TableMatchSrcDestSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
		TableMatchSrcDestSummary record = mostOfIt.mapRow(rs, rowNum);
		return record;

	}
}
