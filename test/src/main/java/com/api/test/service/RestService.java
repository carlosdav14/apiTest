package com.api.test.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.test.controller.ServiceController;
import com.api.test.dto.Data;





@RestController
@RequestMapping("/rest")
@CrossOrigin
public class RestService {
	
	@Autowired
	ServiceController serviceController;
	
	@GetMapping("/find/{name}")
	public List<Data> findDataByName(@PathVariable("name") String name) throws Exception {
		return serviceController.findDataByName(name);		
	}	
}
