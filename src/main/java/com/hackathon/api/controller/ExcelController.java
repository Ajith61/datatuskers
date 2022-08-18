package com.hackathon.api.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
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
import com.hackathon.api.model.FullMatchModel;
import com.hackathon.api.model.ResponseListMessage;
import com.hackathon.api.model.SubMatchModel;
import com.hackathon.api.service.ExcelService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/excel")
public class ExcelController {

	@Autowired
	ExcelService fileService;

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
					}
					// fileNames.add(file.getOriginalFilename());

				});

			} else {
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
				fileService.save(file);

				message = "Stored successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
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
	
	@GetMapping("/get/fullMatchResults")
	public List<FullMatchModel> getFullMatchResults() {
		List<FullMatchModel> datas = fileService.getFullMatchResults();
		return datas;
	}
	
	@GetMapping("/get/subMatchResults")
	public List<SubMatchModel> getSetResults() {
		List<SubMatchModel> datas = fileService.getSetResults();
		return datas;
	}


}