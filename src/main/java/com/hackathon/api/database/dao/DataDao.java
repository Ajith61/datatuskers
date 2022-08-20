package com.hackathon.api.database.dao;

import java.util.List;

import com.hackathon.api.model.DataTable;
import com.hackathon.api.model.FullMatchLongModel;
import com.hackathon.api.model.FullMatchModel;
import com.hackathon.api.model.PartialMatchLongResult;
import com.hackathon.api.model.SearchTableModel;
import com.hackathon.api.model.SubMatchModel;
import com.hackathon.api.model.SubSuperLongResult;
import com.hackathon.api.model.TableMatchColumnSummary;
import com.hackathon.api.model.TableMatchScoreSummary;
import com.hackathon.api.model.TableMatchSrcDestSummary;
import com.hackathon.api.model.TableSummary;

public interface DataDao {
	
	List<DataTable> getAllDatas();
	
	List<DataTable> getDataByTableName(String tableName);
	
	List<DataTable> copyData();
	
	List<FullMatchModel> getFullMatchDatas();
	
	List<SubMatchModel> getSubMatchDatas();
	
	List<FullMatchModel> getPartialMatchShortDatas();
	
	List<SearchTableModel> searchTableDatas(String tableName);
	
	int truncateDataset1Table();
	
	int truncateDataset2Table();
	
	int processingDatas();
	
	List<TableSummary> getTableSummaryResults(String schemaName,String tableName);
	
	
	
	// Copy From Source To Destination
	
	int copyDataFromSOurceToDestination();
	
	int existingTableCopyToDest(String sourceSchemaName, String sourceTableName);
	
	int tableStructCopyToTest(String sourceSchemaName, String sourceTableName,String columnNames);
	
	// Full Match Long Results
	
	List<FullMatchLongModel> getFullMatchLongResult(String schemaName,String tableName);
	
	List<SubSuperLongResult> getSubSuperLongResult(String schemaName,String tableName);
	
	List<PartialMatchLongResult> getPartialMatchLongResult(String schemaName,String tableName);
	
	
	// Table Match Details
	
	List<TableMatchColumnSummary> getTableMatchColumnSummary(String sourceSchemaName, String sourceTableName,String destinationSchemaName, String destinationTableName);
	
	List<TableMatchScoreSummary> getTableMatchScoreSummary(String sourceSchemaName, String sourceTableName,String destinationSchemaName, String destinationTableName);
	
    List<TableMatchSrcDestSummary> getTableMatchSrcSummary(String sourceSchemaName, String sourceTableName,String destinationSchemaName, String destinationTableName);
	
	List<TableMatchSrcDestSummary> getTableMatchDestSummary(String sourceSchemaName, String sourceTableName,String destinationSchemaName, String destinationTableName);
}
