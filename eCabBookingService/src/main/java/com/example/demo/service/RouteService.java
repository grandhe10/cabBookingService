package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RouteDto;
import com.example.demo.dto.RouteResponseDto;

public interface RouteService {
	
	public List<RouteDto> getAllRoutes();
	
	public RouteDto getRouteDetailsById(Long routeId);
	
	public List<RouteDto> getRouteDetailsByLocation(String fromLocation,String toLocation);
	
}
