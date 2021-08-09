package com.weather.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.entity.City;
import com.weather.exception.AppException;
import com.weather.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	public City saveCityWeather(City city) {
		
		
		
		return cityRepository.save(city);
		
	}
	
	public City findCityReportById(Integer cityId) throws Exception {
		return cityRepository.findById(cityId).orElseThrow(()->new AppException(cityId +" not found"));
	}
	
	public Iterable<City> findAllCityReport() {
		return cityRepository.findAll();
	}
	
	public void deleteCityReportById(Integer cityId) throws Exception{
		findCityReportById(cityId);
		cityRepository.deleteById(cityId);
	}
	
	 public void updateCityRecordById(City city, Integer cityId) throws Exception {
		 City findCityReportById = findCityReportById(cityId);
		 if(findCityReportById != null) {
			 findCityReportById.setCityName(city.getCityName());
			 findCityReportById.setCityTemp(city.getCityTemp());
			 findCityReportById.setCityRegion(city.getCityDetails());
			 findCityReportById.setCityRegion(city.getCityDetails());
			 cityRepository.save(city);
		 }
	 }

}
