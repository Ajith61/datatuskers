package com.hackathon.api.database.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.api.model.SubMatchModel;

public class SubMatchRowMapper implements RowMapper<SubMatchModel>{

	private static final RowMapper<SubMatchModel> mostOfIt = new BeanPropertyRowMapper<>(SubMatchModel.class);
	private ObjectMapper objectMapper;

	public SubMatchRowMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public SubMatchModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		SubMatchModel record = mostOfIt.mapRow(rs, rowNum);
		return record;

	}
}
