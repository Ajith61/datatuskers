package com.hackathon.api.database.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.api.model.SubSuperLongResult;

public class SubSuperLongResultRowMapper implements RowMapper<SubSuperLongResult>{

	private static final RowMapper<SubSuperLongResult> mostOfIt = new BeanPropertyRowMapper<>(SubSuperLongResult.class);
	private ObjectMapper objectMapper;

	public SubSuperLongResultRowMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public SubSuperLongResult mapRow(ResultSet rs, int rowNum) throws SQLException {
		SubSuperLongResult record = mostOfIt.mapRow(rs, rowNum);
		return record;

	}
}
