package com.restau.localisationRes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restau.localisationRes.entities.Ville;
import com.restau.localisationRes.entities.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {

	List<Zone> findAll();
	Zone findById(int id);
	Zone findByNomAndVille(String nomZone, Ville ville);
	List<Zone> findByVille(Ville ville);
	Zone findByNomAndVilleNom(String zoneNom, String nom);
	
	
	
}
