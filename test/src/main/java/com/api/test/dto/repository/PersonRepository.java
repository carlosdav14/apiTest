package com.api.test.dto.repository;

import java.util.LinkedList;
import java.util.List;

import io.spring.guides.gs_producing_web_service.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.api.test.controller.ServiceController;
import com.api.test.dto.Data;

@Component
public class PersonRepository {
	@Autowired
	ServiceController serviceController;
	public List<Person> findPersonByName(String name) throws Exception{
		Assert.notNull(name, "The name must not be null");
		LinkedList<Person> persons = new LinkedList<>();
		List<Data> data = serviceController.findDataByName(name);
		for(Data d: data) {
			Person person = new Person();
			person.setName(d.getName());
			person.setService(d.getService());
			person.setServiceUrl(d.getServiceUrl());
			person.setTrackName(d.getTrackName());
			person.setType(d.getType());
			persons.add(person);
		}
		return persons;
	}
}