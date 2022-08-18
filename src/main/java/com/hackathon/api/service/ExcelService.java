package com.hackathon.api.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hackathon.api.database.impl.DataTableImpl;
import com.hackathon.api.helper.ExcelHelper;
import com.hackathon.api.model.DataTable;
import com.hackathon.api.model.FullMatchModel;
import com.hackathon.api.model.SubMatchModel;
import com.hackathon.api.repository.DataTableRepository;

@Service
public class ExcelService {

	@Autowired
	private DataTableRepository repository;
	@Autowired
	private DataTableImpl dataTableImpl;

	public void save(MultipartFile file) {
		try {
			List<DataTable> dataTables = ExcelHelper.excelToDataTable(file.getInputStream());
			repository.saveAll(dataTables);
		} catch (IOException e) {
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
		try {
			List<FullMatchModel> dataRecords = dataTableImpl.getFullMatchDatas();
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			return null;
		}
	}

	public List<SubMatchModel> getSetResults() {
		
		try {
			List<SubMatchModel> dataRecords = dataTableImpl.getSubMatchDatas();
			if (!CollectionUtils.isEmpty(dataRecords)) {
				return dataRecords;
			} else {
				return dataRecords;
			}
		} catch (Exception ex) {
			return null;
		}
	}

}