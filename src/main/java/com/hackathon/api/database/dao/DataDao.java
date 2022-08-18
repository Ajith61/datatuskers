package com.hackathon.api.database.dao;

import java.util.List;

import com.hackathon.api.model.DataTable;
import com.hackathon.api.model.FullMatchModel;
import com.hackathon.api.model.SubMatchModel;

public interface DataDao {
	
	List<DataTable> getAllDatas();
	
	List<DataTable> getDataByTableName(String tableName);
	
	List<DataTable> copyData();
	
	List<FullMatchModel> getFullMatchDatas();
	
	List<SubMatchModel> getSubMatchDatas();

}
