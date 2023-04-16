package com.restau.localisationRes.dao;

import java.util.List;

import com.restau.localisationRes.entities.Serie;

public interface IDao <T> {
	
	void save (T o);
	List<T> findAll();
	void delete(T o);
	void update(T o);
	T findById(int id);
}
