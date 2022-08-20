package com.hackathon.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hackathon.api.controller.ExcelController;
import com.hackathon.api.database.impl.DataTableImpl;
import com.hackathon.api.helper.ExcelHelper;
import com.hackathon.api.model.DataTable;
import com.hackathon.api.model.Dataset1;
import com.hackathon.api.model.Dataset2;
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
import com.hackathon.api.repository.DataTableRepository;
import com.hackathon.api.repository.Dataset1Repository;
import com.hackathon.api.repository.Dataset2Repository;

@Service
public class ExcelService {

	@Autowired
	private DataTableRepository repository;
	@Autowired
	private DataTableImpl dataTableImpl;

	@Autowired
	private Dataset1Repository datasetRepository;
	@Autowired
	private Dataset2Repository dataset2Repository;
	private Logger logger = LoggerFactory.getLogger(ExcelService.class);

	public void save(MultipartFile file) {
		try {
			List<Dataset1> dataTables = ExcelHelper.excelToDataTable(file.getInputStream());
			datasetRepository.saveAll(dataTables);
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage());
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

	public void saveDestinationFile(MultipartFile file) {
		try {
			List<Dataset2> dataTables = ExcelHelper.excelToDataset2Table(file.getInputStream());
			dataset2Repository.saveAll(dataTables);
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage());
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

	public List<DataTable> getAllDatas() {
		return repository.findAll();
	}

	public List<DataTable> getAllDatasUsingFuction() {

		try {
			List<DataTable> dataRecords = dataTableImpl.getAllDatas();
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return null;
			}
		} catch (Exception ex) {
			return null;
		}
	}

	public List<DataTable> getAllDataByTableName(String tableName) {
		try {
			List<DataTable> dataRecords = dataTableImpl.getDataByTableName(tableName);
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			return null;
		}
	}

	public List<DataTable> copyData() {
		try {
			List<DataTable> dataRecords = dataTableImpl.copyData();
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			return null;
		}
	}

	public List<FullMatchModel> getFullMatchResults() {
		List<FullMatchModel> dataRecords = new ArrayList<>();
		try {
			dataRecords = dataTableImpl.getFullMatchDatas();
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return dataRecords;
		}
	}

	public List<SubMatchModel> getSetResults() {
		List<SubMatchModel> dataRecords = new ArrayList<>();
		try {
			dataRecords = dataTableImpl.getSubMatchDatas();
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return dataRecords;
		}
	}

	public List<FullMatchModel> getPartialMatchShortResults() {
		List<FullMatchModel> dataRecords = new ArrayList<>();
		try {
			dataRecords = dataTableImpl.getPartialMatchShortDatas();
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return dataRecords;
		}
	}

	public List<SearchTableModel> searchTableDatas(String tableName) {
		List<SearchTableModel> dataRecords = new ArrayList<>();
		try {
			dataRecords = dataTableImpl.searchTableDatas(tableName);
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return dataRecords;
		}
	}

	public int truncateDataset1Table() {
		try {
			return dataTableImpl.truncateDataset1Table();
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return 0;
		}
	}

	public int truncateDataset2Table() {
		try {
			return dataTableImpl.truncateDataset2Table();
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return 0;
		}
	}

	public int processingDatas() {
		try {
			Thread.sleep(5000);
			return 5;
			// return dataTableImpl.processingDatas();

		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return 0;
		}
	}

	public List<TableSummary> getTableSummaryResults(String schemaName, String tableName) {
		List<TableSummary> dataRecords = new ArrayList<>();
		try {
			dataRecords = dataTableImpl.getTableSummaryResults(schemaName, tableName);
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return dataRecords;
		}
	}

	public List<FullMatchLongModel> getFullMatchLongResults(String schemaName, String tableName) {
		List<FullMatchLongModel> dataRecords = new ArrayList<>();
		try {
			dataRecords = dataTableImpl.getFullMatchLongResult(schemaName, tableName);
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return dataRecords;
		}
	}

	public List<SubSuperLongResult> getSubSuperLongResults(String schemaName, String tableName) {
		List<SubSuperLongResult> dataRecords = new ArrayList<>();
		try {
			dataRecords = dataTableImpl.getSubSuperLongResult(schemaName, tableName);
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return dataRecords;
		}
	}

	public List<PartialMatchLongResult> getPartialMatchShortResults(String schemaName, String tableName) {
		List<PartialMatchLongResult> dataRecords = new ArrayList<>();
		try {
			dataRecords = dataTableImpl.getPartialMatchLongResult(schemaName, tableName);
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return dataRecords;
		}
	}

	public List<TableMatchColumnSummary> getTableMatchColumnSummary(String sourceSchemaName, String sourceTableName,
			String destinationSchemaName, String destinationTableName) {
		List<TableMatchColumnSummary> dataRecords = new ArrayList<>();
		try {
			dataRecords = dataTableImpl.getTableMatchColumnSummary(sourceSchemaName, sourceTableName,
					destinationSchemaName, destinationTableName);
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return dataRecords;
		}
	}

	public List<TableMatchScoreSummary> getTableMatchScoreSummary(String sourceSchemaName, String sourceTableName,
			String destinationSchemaName, String destinationTableName) {
		List<TableMatchScoreSummary> dataRecords = new ArrayList<>();
		try {
			dataRecords = dataTableImpl.getTableMatchScoreSummary(sourceSchemaName, sourceTableName,
					destinationSchemaName, destinationTableName);
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return dataRecords;
		}
	}

	public List<TableMatchSrcDestSummary> getTableMatchSrcSummary(String sourceSchemaName, String sourceTableName,
			String destinationSchemaName, String destinationTableName) {
		List<TableMatchSrcDestSummary> dataRecords = new ArrayList<>();
		try {
			dataRecords = dataTableImpl.getTableMatchSrcSummary(sourceSchemaName, sourceTableName,
					destinationSchemaName, destinationTableName);
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return dataRecords;
		}
	}

	public List<TableMatchSrcDestSummary> getTableMatchDestSummary(String sourceSchemaName, String sourceTableName,
			String destinationSchemaName, String destinationTableName) {
		List<TableMatchSrcDestSummary> dataRecords = new ArrayList<>();
		try {
			dataRecords = dataTableImpl.getTableMatchDestSummary(sourceSchemaName, sourceTableName,
					destinationSchemaName, destinationTableName);
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return dataRecords;
		}
	}

	public int copyDataSrcToDest() {
		try {
			return dataTableImpl.copyDataFromSOurceToDestination();

		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return 0;
		}
	}

	public int existingTableCopyToDest(String schemaName, String tableName) {
		try {
			return dataTableImpl.existingTableCopyToDest(schemaName,tableName);
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return 0;
		}
	}

	public int tableStructCopyToDest(String schemaName, String tableName,String columnNames) {
		try {
			return dataTableImpl.tableStructCopyToTest(schemaName,tableName,columnNames);

		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			return 0;
		}
	}


}