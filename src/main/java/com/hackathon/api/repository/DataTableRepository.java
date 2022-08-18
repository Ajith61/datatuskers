package com.hackathon.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.api.model.DataTable;


public interface DataTableRepository extends JpaRepository<DataTable, Long> {

}
