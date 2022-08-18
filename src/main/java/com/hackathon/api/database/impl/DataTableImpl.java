package com.hackathon.api.database.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hackathon.api.database.dao.DataDao;
import com.hackathon.api.database.rowmapper.DataTableRowMapper;
import com.hackathon.api.database.rowmapper.FullMatchRowMapper;
import com.hackathon.api.database.rowmapper.SubMatchRowMapper;
import com.hackathon.api.database.util.DaoHelper;
import com.hackathon.api.database.util.DaoParameter;
import com.hackathon.api.model.DataTable;
import com.hackathon.api.model.FullMatchModel;
import com.hackathon.api.model.SubMatchModel;
import com.hackathon.api.database.util.DbConstants;
import com.hackathon.api.database.util.ObjectToJsonHelper;;

@Component
public class DataTableImpl implements DataDao{


	private DaoHelper daoHelper;
	@Autowired
	private ObjectToJsonHelper objectToJsonHelper;

	public DataTableImpl() {

	}

	@Autowired
	public DataTableImpl(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
		}

	@Override
	public List<DataTable> getAllDatas() {
		return daoHelper.executeCallForObjects(DbConstants.GET_DATAS,
				new DataTableRowMapper(objectToJsonHelper.getObjectMapper()));
	}

	@Override
	public List<DataTable> getDataByTableName(String tableName) {
		return daoHelper.executeCallForObjects(DbConstants.GET_DATA_BY_TABLE,
				new DataTableRowMapper(objectToJsonHelper.getObjectMapper()),new DaoParameter(tableName, Types.OTHER));
	}

	@Override
	public List<DataTable> copyData() {
		return daoHelper.executeCallForObjects(DbConstants.COPY_DATA,
				new DataTableRowMapper(objectToJsonHelper.getObjectMapper()));
	}

	@Override
	public List<FullMatchModel> getFullMatchDatas() {
		return daoHelper.executeCallForObjects(DbConstants.GET_FULL_MATCH_DATA,
				new FullMatchRowMapper(objectToJsonHelper.getObjectMapper()));
	}

	@Override
	public List<SubMatchModel> getSubMatchDatas() {
		return daoHelper.executeCallForObjects(DbConstants.GET_SUB_MATCH_DATA,
				new SubMatchRowMapper(objectToJsonHelper.getObjectMapper()));
	}
	
}
