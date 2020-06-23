package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Routes;

@Repository
public interface RouteDao extends CrudRepository<Routes, Long> {
	
	public List<Routes> findAll();

	public Optional<List<Routes>> findByFromLocationAndToLocation(String fromLocation,String toLocation);

	public Optional<Routes> findByRouteId(Long routeId);
	
	public Optional<List<Routes>> findByFromLocationAndToLocationContaining(String fromLocation,String toLocation);

	public Optional<List<Routes>> findByFromLocationContainingAndToLocationContaining(String fromLocation,
			String toLocation);
}
