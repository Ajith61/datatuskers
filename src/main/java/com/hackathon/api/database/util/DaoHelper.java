package com.hackathon.api.database.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class DaoHelper {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Logger log = LoggerFactory.getLogger(DaoHelper.class);
	private RowMapper<Integer> singleColumnIntegerMapper = (resultSet, i) -> resultSet.getInt(1);
	
	public <T> List<T> executeCallForObjects(String functionName, RowMapper<T> rowMapper, DaoParameter... params) {
		log.debug("Calling: {}", functionName);

		Object[] args = DaoHelper.buildArgs(params);
		int[] argTypes = DaoHelper.buildArgsTypes(params);
		String sql = DaoHelper.buildSql(functionName, params);
		return jdbcTemplate.query(sql, args, argTypes, rowMapper);
	}


	private static String buildSql(String functionName, DaoParameter... params) {
		int count = params == null ? 0 : params.length;
		return "select * from " + functionName + "(" + StringUtils.repeat("?", ",", count) + ")";
	}

	private static Object[] buildArgs(DaoParameter... params) {
		int count = params == null ? 0 : params.length;
		Object[] result = new Object[count];
		for (int i = 0; i < count; i++) {
			result[i] = params[i].getValue();
		}
		return result;
	}

	private static int[] buildArgsTypes(DaoParameter... params) {
		int count = params == null ? 0 : params.length;
		int[] result = new int[count];
		for (int i = 0; i < count; i++) {
			result[i] = params[i].getType();
		}
		return result;
	}
	
	public int executeCallForInt(String functionName, DaoParameter... params) {
		log.debug("Calling: {}", functionName);

		Object[] args = DaoHelper.buildArgs(params);
		int[] argTypes = DaoHelper.buildArgsTypes(params);
		String sql = DaoHelper.buildSql(functionName, params);
		List<Integer> results = jdbcTemplate.query(sql, args, argTypes, singleColumnIntegerMapper);
		if (results.isEmpty()) {
			
		}
		return results.get(0);
	}
}
