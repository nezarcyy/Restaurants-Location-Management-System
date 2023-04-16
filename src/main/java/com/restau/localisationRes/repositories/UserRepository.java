package com.restau.localisationRes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restau.localisationRes.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findAll();
	User findById(int id);

	User findByNom(String nomVille);	

}
