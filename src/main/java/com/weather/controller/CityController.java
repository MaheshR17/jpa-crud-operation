package com.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.weather.entity.City;
import com.weather.exception.AppException;
import com.weather.repository.CityRepository;
import com.weather.service.CityService;

@RestController
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping("/weather")
	public String sayHello() {
		return "Welcome to WeatherApp";

	}

	@PostMapping(value = "/createRecord")
	public ResponseEntity<City> saveReport(@RequestBody City city) {
		City weather = cityService.saveCityWeather(city);
		return new ResponseEntity<City>(weather, HttpStatus.CREATED);
	}

	@GetMapping(value = "/fetctAllRecords")
	public Iterable<City> fetchAllRecords() {
		return cityService.findAllCityReport();
	}
	
	@GetMapping(value = "/fetchReportByID/{cityId}")
	public City fetchCityWeatherById(@PathVariable Integer cityId) throws Exception {
		return cityService.findCityReportById(cityId);
	}
	
	@DeleteMapping(value = "/deleteById/{cityId}")
	public ResponseEntity<Object> deleteById(@PathVariable  Integer cityId) throws Exception {
		 try {
			cityService.deleteCityReportById(cityId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (AppException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PutMapping("/updateCityReport/{cityId}")
	public void updateCityReportById(@RequestBody City city, @PathVariable Integer cityId) throws Exception {
		cityService.updateCityRecordById(city, cityId);
	}

}
