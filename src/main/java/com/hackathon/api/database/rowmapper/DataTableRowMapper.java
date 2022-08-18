package com.hackathon.api.database.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.api.model.DataTable;

public class DataTableRowMapper implements RowMapper<DataTable>{

		private static final RowMapper<DataTable> mostOfIt = new BeanPropertyRowMapper<>(DataTable.class);
		private ObjectMapper objectMapper;

		public DataTableRowMapper(ObjectMapper objectMapper) {
			this.objectMapper = objectMapper;
		}

		@Override
		public DataTable mapRow(ResultSet rs, int rowNum) throws SQLException {
			DataTable record = mostOfIt.mapRow(rs, rowNum);
			return record;

		}
}
