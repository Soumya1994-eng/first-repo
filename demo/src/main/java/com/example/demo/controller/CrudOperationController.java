package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepo;

@RestController
public class CrudOperationController {
    
	@Autowired
	CompanyRepo companyRepo;
	
	@PostMapping(value="/insert")
	public void insert(@RequestBody Company company) {
		companyRepo.insertData(company.getId(),company.getName(),company.getAge(),company.getAddress());
	}
	
	@PutMapping(value="/update")
	public void update(@RequestParam int age,@RequestParam int id) {
		companyRepo.updateData(age,id);
	}
	
	@GetMapping(value="/select")
	public void select() {
		companyRepo.getData();
	}

	@DeleteMapping(value="/delete")
	public void delete(@RequestParam int id) {
		companyRepo.deleteData(id);
		
	}
}