package com.hackathon.api.database.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.api.model.FullMatchModel;

public class FullMatchRowMapper implements RowMapper<FullMatchModel>{

	private static final RowMapper<FullMatchModel> mostOfIt = new BeanPropertyRowMapper<>(FullMatchModel.class);
	private ObjectMapper objectMapper;

	public FullMatchRowMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public FullMatchModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		FullMatchModel record = mostOfIt.mapRow(rs, rowNum);
		return record;

	}
}
