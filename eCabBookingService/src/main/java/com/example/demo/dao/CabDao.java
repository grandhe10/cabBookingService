package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cab;
@Repository
public interface CabDao extends CrudRepository<Cab, Long>{
	
	public Optional<List<Cab>> findAllByRouteId(Long routeId); 
	
	public Optional<Cab> findByCabId(Long cabId);
	
	public Optional<List<Cab>> findByStatusAndRouteId(String status,Long routeId);

	public Optional<Cab> findByRouteIdAndCabId(Long routeId, Long cabId);

	
	
}
