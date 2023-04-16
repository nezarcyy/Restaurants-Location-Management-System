package com.restau.localisationRes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restau.localisationRes.entities.Specialite;
import com.restau.localisationRes.entities.User;
import com.restau.localisationRes.repositories.SpecialiteRepository;
import com.restau.localisationRes.repositories.UserRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {


	@Autowired
	private UserRepository userRepository;

	@PostMapping("/save")
	public void save(@RequestBody User serie) {
		userRepository.save(serie);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		User s = userRepository.findById(Integer.parseInt(id));
		userRepository.delete(s);
	}

	@GetMapping("/all")
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping(value = "/count")
	public long countStudent() {
		return userRepository.count();
	}
	@GetMapping("/{id}")
	public User findById(@PathVariable int id) {
		return userRepository.findById(id);
	}
}

