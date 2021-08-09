package com.weather.repository;

import org.springframework.data.repository.CrudRepository;

import com.weather.entity.City;

public interface CityRepository extends CrudRepository<City, Integer> {

}
