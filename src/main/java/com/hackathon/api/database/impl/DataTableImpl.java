package com.hackathon.api.database.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hackathon.api.database.dao.DataDao;
import com.hackathon.api.database.rowmapper.DataTableRowMapper;
import com.hackathon.api.database.rowmapper.FullMatchLongRowMapper;
import com.hackathon.api.database.rowmapper.FullMatchRowMapper;
import com.hackathon.api.database.rowmapper.PartialMatchLongResultRowMapper;
import com.hackathon.api.database.rowmapper.SearchTableRowMapper;
import com.hackathon.api.database.rowmapper.SubMatchRowMapper;
import com.hackathon.api.database.rowmapper.SubSuperLongResultRowMapper;
import com.hackathon.api.database.rowmapper.TableMatchColumnSummaryRowMapper;
import com.hackathon.api.database.rowmapper.TableMatchScoreSummaryRowMapper;
import com.hackathon.api.database.rowmapper.TableSummaryRowMapper;
import com.hackathon.api.database.util.DaoHelper;
import com.hackathon.api.database.util.DaoParameter;
import com.hackathon.api.model.DataTable;
import com.hackathon.api.model.FullMatchLongModel;
import com.hackathon.api.model.FullMatchModel;
import com.hackathon.api.model.PartialMatchLongResult;
import com.hackathon.api.model.SearchTableModel;
import com.hackathon.api.model.SubMatchModel;
import com.hackathon.api.model.SubSuperLongResult;
import com.hackathon.api.model.TableMatchColumnSummary;
import com.hackathon.api.model.TableMatchScoreSummary;
import com.hackathon.api.model.TableSummary;
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
		return daoHelper.executeCallForObjects(DbConstants.GET_FULL_MATCH_SHORT_DATA,
				new FullMatchRowMapper(objectToJsonHelper.getObjectMapper()));
	}

	@Override
	public List<SubMatchModel> getSubMatchDatas() {
		return daoHelper.executeCallForObjects(DbConstants.GET_SUB_MATCH_SHORT_DATA,
				new SubMatchRowMapper(objectToJsonHelper.getObjectMapper()));
	}

	@Override
	public List<FullMatchModel> getPartialMatchShortDatas() {
		return daoHelper.executeCallForObjects(DbConstants.GET_PARTIAL_MATCH_SHORT_DATA,
				new FullMatchRowMapper(objectToJsonHelper.getObjectMapper()));
	}
	
	@Override
	public List<SearchTableModel> searchTableDatas(String tableName) {
		return daoHelper.executeCallForObjects(DbConstants.SEARCH_TABLE_DATA,
				new SearchTableRowMapper(objectToJsonHelper.getObjectMapper()),new DaoParameter(tableName, Types.VARCHAR));
	}


	@Override
	public int truncateDataset1Table() {
		return daoHelper.executeCallForInt(DbConstants.TRUNCATE_DATASET1_TABLE);
	}

	@Override
	public int truncateDataset2Table() {
		return daoHelper.executeCallForInt(DbConstants.TRUNCATE_DATASET2_TABLE);
	}

	@Override
	public int processingDatas() {
		return daoHelper.executeCallForInt(DbConstants.PROCESSING_DATA);
	}

	@Override
	public List<TableSummary> getTableSummaryResults(String schemaName,String tableName) {
		return daoHelper.executeCallForObjects(DbConstants.TABLE_SUMMARY,
				new TableSummaryRowMapper(objectToJsonHelper.getObjectMapper()),new DaoParameter(schemaName, Types.VARCHAR),new DaoParameter(tableName, Types.VARCHAR));
	}

	
	// Full Match Long Results 
	
	@Override
	public List<FullMatchLongModel> getFullMatchLongResult(String schemaName,String tableName) {
		return daoHelper.executeCallForObjects(DbConstants.FULL_MATCH_LONG_RESULTS,
				new FullMatchLongRowMapper(objectToJsonHelper.getObjectMapper()),new DaoParameter(schemaName, Types.OTHER),new DaoParameter(tableName, Types.OTHER));
	}

	@Override
	public List<SubSuperLongResult> getSubSuperLongResult(String schemaName, String tableName) {
		return daoHelper.executeCallForObjects(DbConstants.SUB_SUPER_LONG_RESULTS,
				new SubSuperLongResultRowMapper(objectToJsonHelper.getObjectMapper()),new DaoParameter(schemaName, Types.OTHER),new DaoParameter(tableName, Types.OTHER));
	}

	@Override
	public List<PartialMatchLongResult> getPartialMatchLongResult(String schemaName, String tableName) {
		return daoHelper.executeCallForObjects(DbConstants.PARTIAL_MATCH_LONG_RESULTS,
				new PartialMatchLongResultRowMapper(objectToJsonHelper.getObjectMapper()),new DaoParameter(schemaName, Types.OTHER),new DaoParameter(tableName, Types.OTHER));
	}

	@Override
	public List<TableMatchColumnSummary> getTableMatchColumnSummary(String sourceSchemaName, String sourceTableName,String destinationSchemaName, String destinationTableName) {
		return daoHelper.executeCallForObjects(DbConstants.TABLE_MATCH_COLUMN_SUMMARY,
				new TableMatchColumnSummaryRowMapper(objectToJsonHelper.getObjectMapper()),
				new DaoParameter(sourceSchemaName, Types.OTHER),new DaoParameter(sourceTableName, Types.OTHER),
				new DaoParameter(destinationSchemaName, Types.OTHER),new DaoParameter(destinationTableName, Types.OTHER));
	}

	@Override
	public List<TableMatchScoreSummary> getTableMatchScoreSummary(String sourceSchemaName, String sourceTableName,String destinationSchemaName, String destinationTableName) {
		return daoHelper.executeCallForObjects(DbConstants.TABLE_MATCH_SCORE_SUMMARY,
				new TableMatchScoreSummaryRowMapper(objectToJsonHelper.getObjectMapper()),
				new DaoParameter(sourceSchemaName, Types.OTHER),new DaoParameter(sourceTableName, Types.OTHER),
				new DaoParameter(destinationSchemaName, Types.OTHER),new DaoParameter(destinationTableName, Types.OTHER));
	}


}
