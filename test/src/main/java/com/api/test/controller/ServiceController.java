package com.api.test.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.api.test.dto.Data;
import com.api.test.dto.itunes.DataItunes;
import com.api.test.dto.itunes.Result;
import com.api.test.dto.tvmaze.DataTvMaze;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ServiceController {
	
	private static final String tvMazeUrl = "https://api.tvmaze.com/search/people?q=";
	private static final String itunesUrl = "https://itunes.apple.com/search?term=";
	
	public List<Data> findDataByName(String name) throws Exception{
		
		List<Data> allDataService = new LinkedList<>();
		
		allDataService.addAll(findDataTvMaze(name));
		allDataService.addAll(findDataItunes(name));
		
		return allDataService;
	}
	
	private HttpHeaders getHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return httpHeaders;
	}
	
	public List<Data> findDataTvMaze(String name) throws Exception{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = getHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		List<Data> dataService = new LinkedList<>();
		try {
			ResponseEntity<List<DataTvMaze>> responseEntity = restTemplate.exchange(tvMazeUrl+name, HttpMethod.GET,
					httpEntity, new ParameterizedTypeReference<List<DataTvMaze>>() {
					});
			if (responseEntity.hasBody()) {
				
				for(DataTvMaze d:responseEntity.getBody()) {
					Data registry = new Data();
					registry.setService("API TVMAZE");
					registry.setServiceUrl(tvMazeUrl+name);
					registry.setName(d.getPerson().getName());
					registry.setType("People");
					dataService.add(registry);	
				}
			}
			
			
			return dataService;
		} catch (HttpClientErrorException hcee) {
			throw new Exception("Error in API TvMaze", hcee);
		} catch (RestClientException rce) {
			throw new Exception("Error when trying to consume service TvMaze", rce);
		} catch (Exception ex) {
			throw new Exception("Unexpected error", ex);
		}
	}
	
	public List<Data> findDataItunes(String name) throws Exception{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = getHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		List<Data> dataService = new LinkedList<>();
		ResponseEntity<String> responseEntity = restTemplate.exchange(itunesUrl+name, HttpMethod.GET,
				httpEntity, new ParameterizedTypeReference<String>() {
				});
		if (responseEntity.hasBody()) {
			ObjectMapper objectMapper = new ObjectMapper();
			DataItunes dataItunes = objectMapper.readValue(responseEntity.getBody(),DataItunes.class);
			for(Result r: dataItunes.getResults()) {
				Data registry = new Data();
				registry.setService("API ITUNES");
				registry.setServiceUrl(itunesUrl+name);
				registry.setName(r.getArtistName());
				registry.setTrackName(r.getTrackName());
				registry.setType(r.getWrapperType());
				dataService.add(registry);
			}
		}
		return dataService;
	}
	
}
