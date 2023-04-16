package com.restau.localisationRes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.restau.localisationRes.entities.Restaurant;
import com.restau.localisationRes.entities.Specialite;
import com.restau.localisationRes.entities.Ville;
import com.restau.localisationRes.entities.Zone;
import com.restau.localisationRes.services.RestaurantService;
import com.restau.localisationRes.services.SpecialiteService;
import com.restau.localisationRes.repositories.VilleRepository;
import com.restau.localisationRes.services.VilleService;
import com.restau.localisationRes.repositories.ZoneRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/villes")
@CrossOrigin("http://localhost:3000")
public class VilleController {
	
	@Autowired(required=true)
	private VilleService villeService;
	@Autowired(required=true)
	private VilleRepository villeRepository;
	@Autowired(required=true)
	private ZoneRepository zoneRepository;
	

	@PostMapping("/save")
	public void save(@RequestBody Ville serie) {
		villeService.save(serie);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Ville s = villeService.findById(Integer.parseInt(id));
		villeService.delete(s);
	}

	@GetMapping("/all")
	public List<Ville> findAll() {
		return villeService.findAll();
	}

	//@GetMapping(value = "/count")
	//public long countStudent() {
	//	return villeService.count();
	//}

	@GetMapping("/{id}")
	public Ville findById(@PathVariable int id) {
		return villeService.findById(id);
	}

	@GetMapping("/{nomVille}/zones")
	public List<Zone> getZonesForVille(@PathVariable String nomVille) throws Exception {
		Ville ville = villeService.findByNom(nomVille);
		if (ville == null) {
			throw new Exception("La ville avec le nom " + nomVille + " n'existe pas.");
		}
		return ville.getZones();
	}
	
	@GetMapping("/{ville}/zones/{zone}/restaurants")
	public List<Restaurant> getRestaurantsByZone(@PathVariable("ville") String villeNom,
			@PathVariable("zone") String zoneNom) {
		Ville ville = villeRepository.findByNom(villeNom);
		Zone zone = zoneRepository.findByNomAndVilleNom(zoneNom, ville.getNom());
		return zone.getRestaurants();
	}

	@GetMapping("/{ville}/zones/{zone}/restaurants/specialite={specialite}")
	public List<Restaurant> getRestaurantsBySpecialite(@PathVariable String ville, @PathVariable String zone,
			@PathVariable String specialite) {
		Ville v = villeRepository.findByNom(ville);
		Zone z = zoneRepository.findByNomAndVilleNom(zone, v.getNom());
		List<Restaurant> restaurants = z.getRestaurants();
		List<Restaurant> filteredRestaurants = new ArrayList<>();
		for (Restaurant r : restaurants) {
			//
			//
			for (Specialite s : r.getSpecialite()) {
				if (s.getNom().equals(specialite)) {
					filteredRestaurants.add(r);
					break;
				}
			}

		}
		return filteredRestaurants;
	}

	@GetMapping("/{ville}/zones/{zone}/restaurants/serie={serie}")
	public List<Restaurant> getRestaurantsBySerie(@PathVariable String ville, @PathVariable String zone,
			@PathVariable String serie) {
		Ville v = villeRepository.findByNom(ville);
		Zone z = zoneRepository.findByNomAndVilleNom(zone, v.getNom());
		List<Restaurant> restaurants = z.getRestaurants();
		List<Restaurant> filteredRestaurants = new ArrayList<>();
		for (Restaurant r : restaurants) {

			if (r.getSerie().getNom().equals(serie)) {
				filteredRestaurants.add(r);

			}

		}
		return filteredRestaurants;
	}

	@GetMapping("/{ville}/zones/{zone}/restaurants/{id}")
	public List<Restaurant> getRestaurantsByZoneAndId(@PathVariable String ville, @PathVariable String zone,
			@PathVariable int id) {
		Ville v = villeRepository.findByNom(ville);
		Zone z = zoneRepository.findByNomAndVilleNom(zone, v.getNom());
		List<Restaurant> restaurants = z.getRestaurants();
		List<Restaurant> filteredRestaurants = new ArrayList<>();
		for (Restaurant r : restaurants) {

			if (r.getId() == id) {
				filteredRestaurants.add(r);

			}

		}
		return filteredRestaurants;
	}
	
}
