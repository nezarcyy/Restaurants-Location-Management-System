package com.restau.localisationRes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restau.localisationRes.dao.IDao;
import com.restau.localisationRes.entities.Restaurant;
import com.restau.localisationRes.entities.Ville;
import com.restau.localisationRes.repositories.RestaurantRepository;



@Service
public class RestaurantService implements IDao<Restaurant> {
	
	@Autowired(required=true)
	private RestaurantRepository restaurantRepository;

	@Override
	public void save(Restaurant o) {
		restaurantRepository.save(o);
		
	}

	@Override
	public List<Restaurant> findAll() {
		
		return restaurantRepository.findAll();
	}

	@Override
	public void delete(Restaurant o) {
		restaurantRepository.delete(o);
		
	}

	@Override
	public void update(Restaurant o) {
		restaurantRepository.save(o);
		
	}

	@Override
	public Restaurant findById(int id) {
		
		return restaurantRepository.findById(id);
	}
	
	public Restaurant findByNom(String nomRestaurant) {
		return restaurantRepository.findByNom(nomRestaurant);
	}


}
