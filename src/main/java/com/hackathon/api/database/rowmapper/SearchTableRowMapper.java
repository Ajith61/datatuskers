package com.hackathon.api.database.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.api.model.SearchTableModel;

public class SearchTableRowMapper implements RowMapper<SearchTableModel>{

	private static final RowMapper<SearchTableModel> mostOfIt = new BeanPropertyRowMapper<>(SearchTableModel.class);
	private ObjectMapper objectMapper;

	public SearchTableRowMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public SearchTableModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		SearchTableModel record = mostOfIt.mapRow(rs, rowNum);
		return record;

	}
}
