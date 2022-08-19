package com.hackathon.api.database.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.api.model.PartialMatchLongResult;


public class PartialMatchLongResultRowMapper implements RowMapper<PartialMatchLongResult>{

	private static final RowMapper<PartialMatchLongResult> mostOfIt = new BeanPropertyRowMapper<>(PartialMatchLongResult.class);
	private ObjectMapper objectMapper;

	public PartialMatchLongResultRowMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public PartialMatchLongResult mapRow(ResultSet rs, int rowNum) throws SQLException {
		PartialMatchLongResult record = mostOfIt.mapRow(rs, rowNum);
		return record;

	}
}
