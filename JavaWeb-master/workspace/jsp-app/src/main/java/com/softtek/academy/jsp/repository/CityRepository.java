package com.softtek.academy.jsp.repository;

import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.jsp.domain.model.City;
import com.softtek.academy.jsp.domain.model.State;

public class CityRepository {

	private static List<City> cities = new ArrayList<City>();
	
	static {
		final StateRepository stateRepository = new StateRepository();
		
		final State bajaCalifornia = stateRepository.getOne(1L);
		final State bajaCaliforniaSur = stateRepository.getOne(2L);
		
		cities.add(new City(11L, "Mexicali", bajaCalifornia));
		cities.add(new City(12L, "Tijuana", bajaCalifornia));
		cities.add(new City(13L, "Ensenada", bajaCalifornia));
		cities.add(new City(21L, "La Paz", bajaCaliforniaSur));
	}

	
	public City getOne(final Long id) {
		for (final City city : CityRepository.cities) {
			if (city.getId().equals(id))
				return city;
		}
		
		return null;
	}
	
	public List<City> list() {
		return CityRepository.cities;
	}
	
	public void save(final City city) {
		CityRepository.cities.add(city);
	}
	
	public void update(final City city) {
		final City originalCity = this.getOne(city.getId());
		
		originalCity.setDescription(city.getDescription());
		originalCity.setState(city.getState());
		
	}
	
}