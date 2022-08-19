package com.hackathon.api.database.util;

public class DbConstants {

	// Functions - datas
	public final static String GET_DATAS = "get_data";
	public final static String GET_DATA_BY_TABLE = "get_data_by_table";
	public final static String COPY_DATA = "copy_src_to_dest";
	public final static String SEARCH_TABLE_DATA = "table_search";
	public final static String TRUNCATE_DATASET1_TABLE = "fun_table_dataset1_truncate";
	public final static String TRUNCATE_DATASET2_TABLE = "fun_table_dataset2_truncate";
	public final static String PROCESSING_DATA = "data_processing";

//Functions - TABLE PROFILE	
	public final static String TABLE_SUMMARY = "table_summary";
	public final static String FULL_MATCH_LONG_RESULTS = "full_match_long_result";
	public final static String SUB_SUPER_LONG_RESULTS = "sub_super_long_result";
	public final static String PARTIAL_MATCH_LONG_RESULTS = "partial_match_long_result";

	// Functions - TABLE MATCH DETAILS
	public final static String TABLE_MATCH_SOURCE_SUMMARY = "table_match_src_summary";
	public final static String TABLE_MATCH_DEST_SUMMARY = "table_match_dest_summary";
	public final static String TABLE_MATCH_COLUMN_SUMMARY = "table_match_column_summary";
	public final static String TABLE_MATCH_SCORE_SUMMARY = "table_match_score_summary";
	
// Functions - SHORT RESULTS
	public final static String GET_FULL_MATCH_SHORT_DATA = "full_match_short_result";
	public final static String GET_SUB_MATCH_SHORT_DATA = "sub_super_short_result";
	public final static String GET_PARTIAL_MATCH_SHORT_DATA = "partial_match_short_result";
}
