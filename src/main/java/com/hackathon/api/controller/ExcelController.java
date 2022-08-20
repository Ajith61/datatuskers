package com.hackathon.api.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.hackathon.api.helper.ExcelHelper;
import com.hackathon.api.message.ResponseMessage;
import com.hackathon.api.model.DataTable;
import com.hackathon.api.model.FileUtil;
import com.hackathon.api.model.FullMatchLongModel;
import com.hackathon.api.model.FullMatchModel;
import com.hackathon.api.model.PartialMatchLongResult;
import com.hackathon.api.model.ResponseListMessage;
import com.hackathon.api.model.SearchTableModel;
import com.hackathon.api.model.SubMatchModel;
import com.hackathon.api.model.SubSuperLongResult;
import com.hackathon.api.model.TableMatchColumnSummary;
import com.hackathon.api.model.TableMatchScoreSummary;
import com.hackathon.api.model.TableMatchSrcDestSummary;
import com.hackathon.api.model.TableSummary;
import com.hackathon.api.service.ExcelService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/excel")
public class ExcelController {

	@Autowired
	ExcelService fileService;
	private Logger logger = LoggerFactory.getLogger(ExcelController.class);
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile[] files) {
		String message = "";
		for (MultipartFile file : files) {

			if (ExcelHelper.hasExcelFormat(file)) {
				// read and write the file to the local folder
				Arrays.asList(files).stream().forEach(filed -> {
					byte[] bytes = new byte[0];

					try {
						bytes = file.getBytes();
						Files.write(Paths.get(FileUtil.folderPath + file.getOriginalFilename()), bytes);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logger.error(e.getLocalizedMessage());
					}
					// fileNames.add(file.getOriginalFilename());

				});

			} else {
				logger.error( "Please upload an excel file!");
				message = "Please upload an excel file!";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
			}

		}
		message = "Uploaded successfully!";
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

	}

	@PostMapping("/store")
	public ResponseEntity<ResponseMessage> storeExcelToDB(@RequestParam("file") MultipartFile file) {
		String message = "";
		if (ExcelHelper.hasExcelFormat(file)) {
			try {
				logger.info("Truncate table starting!");
				fileService.truncateDataset1Table();
				logger.info("Truncate table completed!");
				fileService.save(file);
				logger.info("Datas stored!");
				message = "Stored successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				logger.error( "Could not upload the file: " + file.getOriginalFilename() + "!");
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		} else {
			message = "Please upload an excel file!";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
		}

	}
	
	@PostMapping("/store/destinationFile")
	public ResponseEntity<ResponseMessage> storeDestinationExcelToDB(@RequestParam("file") MultipartFile file) {
		String message = "";
		if (ExcelHelper.hasExcelFormat(file)) {
			try {
				logger.info("Truncate table starting!");
				fileService.truncateDataset2Table();
				logger.info("Truncate table completed!");
				fileService.saveDestinationFile(file);
				logger.info("Datas stored!");
				message = "Stored successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				logger.error( "Could not upload the file: " + file.getOriginalFilename() + "!");
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		} else {
			message = "Please upload an excel file!";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
		}

	}
	
	@GetMapping("/getDatas")
	public  List<DataTable> getData() {
		return fileService.getAllDatas();
	}
	
	@GetMapping("/getData")
	public  ResponseEntity<ResponseListMessage> getDatas() {
		List<DataTable> datas = fileService.getAllDatas();
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseListMessage("success",datas));
	}
	
	@GetMapping("/get/all-datas")
	public List<DataTable> getAllUsers() {
		List<DataTable> datas = fileService.getAllDatasUsingFuction();
		return datas;
	}
	
	@GetMapping("/get/data")
	public List<DataTable> getAllUsers(@RequestParam("tableName") String tableName) {
		List<DataTable> datas = fileService.getAllDataByTableName(tableName);
		return datas;
	}
	
	@GetMapping("/copy/data")
	public List<DataTable> copyData() {
		List<DataTable> datas = fileService.copyData();
		return datas;
	}
	
	
	// Short Results
	
	@GetMapping("/get/fullMatchShortResults")
	public List<FullMatchModel> getFullMatchShortResults() {
		List<FullMatchModel> datas = fileService.getFullMatchResults();
		return datas;
	}
	
	@GetMapping("/get/subMatchShortResults")
	public List<SubMatchModel> getSubMatchShortResults() {
		List<SubMatchModel> datas = fileService.getSetResults();
		return datas;
	}
	
	@GetMapping("/get/partialMatchShortResults")
	public List<FullMatchModel> getPartialMatchShortResults() {
		List<FullMatchModel> datas = fileService.getPartialMatchShortResults();
		return datas;
	}
	
	
	@GetMapping("/get/searchTableDatas")
	public List<SearchTableModel> searchTableDatas(@RequestParam("tableName") String tableName) {
		List<SearchTableModel> datas = fileService.searchTableDatas(tableName);
		return datas;
	}
	
	@GetMapping("/get/processData")
	public int processingData() {
		int datas = fileService.processingDatas();
		return datas;
	}
	
	@GetMapping("/get/tableSummary")
	public List<TableSummary> getTableSummaryResults(@RequestParam("schemaName") String schemaName,@RequestParam("tableName") String tableName) {
		List<TableSummary> datas = fileService.getTableSummaryResults(schemaName,tableName);
		return datas;
	}
	
	// Full Match Long Results
	
	@GetMapping("/get/fullMatchLongResults")
	public List<FullMatchLongModel> getFullMatchLongResults(@RequestParam("schemaName") String schemaName,@RequestParam("tableName") String tableName) {
		List<FullMatchLongModel> datas = fileService.getFullMatchLongResults(schemaName,tableName);
		return datas;
	}
	
	@GetMapping("/get/subSuperLongResults")
	public List<SubSuperLongResult> getSubSuperLongResults(@RequestParam("schemaName") String schemaName,@RequestParam("tableName") String tableName) {
		List<SubSuperLongResult> datas = fileService.getSubSuperLongResults(schemaName,tableName);
		return datas;
	}
	
	@GetMapping("/get/partialMatchLongResults")
	public List<PartialMatchLongResult> getPartialMatchLongResults(@RequestParam("schemaName") String schemaName,@RequestParam("tableName") String tableName) {
		List<PartialMatchLongResult> datas = fileService.getPartialMatchShortResults(schemaName,tableName);
		return datas;
	}
	
	// Table Match Details
	
	@GetMapping("/get/getTableMatchColumnSummary")
	public List<TableMatchColumnSummary> getTableMatchColumnSummary(@RequestParam("sourceSchemaName") String sourceSchemaName,
			@RequestParam("sourceTableName") String sourceTableName,@RequestParam("destinationSchemaName") String destinationSchemaName,
			@RequestParam("destinationTableName") String destinationTableName) {
		List<TableMatchColumnSummary> datas = fileService.getTableMatchColumnSummary(sourceSchemaName, sourceTableName,destinationSchemaName,destinationTableName);
		return datas;
	}
	
	@GetMapping("/get/getTableMatchScoreSummary")
	public List<TableMatchScoreSummary> getTableMatchScoreSummary(@RequestParam("sourceSchemaName") String sourceSchemaName,
			@RequestParam("sourceTableName") String sourceTableName,@RequestParam("destinationSchemaName") String destinationSchemaName,
			@RequestParam("destinationTableName") String destinationTableName) {
		List<TableMatchScoreSummary> datas = fileService.getTableMatchScoreSummary(sourceSchemaName, sourceTableName,destinationSchemaName,destinationTableName);
		return datas;
	}
	
	@GetMapping("/get/getTableMatchSrcSummary")
	public List<TableMatchSrcDestSummary> getTableMatchSrcSummary(@RequestParam("sourceSchemaName") String sourceSchemaName,
			@RequestParam("sourceTableName") String sourceTableName,@RequestParam("destinationSchemaName") String destinationSchemaName,
			@RequestParam("destinationTableName") String destinationTableName) {
		List<TableMatchSrcDestSummary> datas = fileService.getTableMatchSrcSummary(sourceSchemaName, sourceTableName,destinationSchemaName,destinationTableName);
		return datas;
	}
	
	@GetMapping("/get/getTableMatchDestSummary")
	public List<TableMatchSrcDestSummary> getTableMatchDestSummary(@RequestParam("sourceSchemaName") String sourceSchemaName,
			@RequestParam("sourceTableName") String sourceTableName,@RequestParam("destinationSchemaName") String destinationSchemaName,
			@RequestParam("destinationTableName") String destinationTableName) {
		List<TableMatchSrcDestSummary> datas = fileService.getTableMatchDestSummary(sourceSchemaName, sourceTableName,destinationSchemaName,destinationTableName);
		return datas;
	}
	
	@GetMapping("/get/copySrcToDesc")
	public int copyDataFromSourceToDestination() {
		int datas = fileService.copyDataSrcToDest();
		return datas;
	}
	
	@GetMapping("/get/existingTableCopyToDest")
	public int existingTableCopyToDest(@RequestParam("schemaName") String schemaName,@RequestParam("tableName") String tableName) {
		int datas = fileService.existingTableCopyToDest(schemaName,tableName);
		return datas;
	}
	
	@GetMapping("/get/tableStructCopyToDest")
	public int tableStructCopyToDest(@RequestParam("schemaName") String schemaName,@RequestParam("tableName") String tableName,@RequestParam("columnNames") String columnNames) {
		int datas = fileService.tableStructCopyToDest(schemaName,tableName,columnNames);
		return datas;
	}

}