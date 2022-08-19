package com.hackathon.api.database.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.api.model.FullMatchLongModel;

public class FullMatchLongRowMapper implements RowMapper<FullMatchLongModel>{

	private static final RowMapper<FullMatchLongModel> mostOfIt = new BeanPropertyRowMapper<>(FullMatchLongModel.class);
	private ObjectMapper objectMapper;

	public FullMatchLongRowMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public FullMatchLongModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		FullMatchLongModel record = mostOfIt.mapRow(rs, rowNum);
		return record;

	}
}
