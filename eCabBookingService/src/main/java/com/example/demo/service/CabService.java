package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CabDto;

public interface CabService {
	
	public List<CabDto> getAllCabDetailsByRouteId(Long routeId);
	
	public List<CabDto> getCabDetailsByAvailability(String status,Long routeId);

	public List<CabDto> getCabDetailsByRoutes(String fromLocation, String toLocation);
 
}
