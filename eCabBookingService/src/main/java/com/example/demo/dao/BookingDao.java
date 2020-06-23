package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Booking;
@Repository
public interface BookingDao extends CrudRepository<Booking, Long>{
	
	public Optional<List<Booking>> findAllByUserId(Long userId);

}
