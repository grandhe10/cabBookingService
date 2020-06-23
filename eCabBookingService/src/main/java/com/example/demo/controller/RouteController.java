package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RouteDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.RouteService;

@RestController
public class RouteController {
	@Autowired
	RouteService routeService;

	@GetMapping("/routes")
	public ResponseEntity<List<RouteDto>> getAllRoutes() {
		return new ResponseEntity<List<RouteDto>>(routeService.getAllRoutes(), HttpStatus.OK);
	}

	@GetMapping("/routes/{routeId}")
	public ResponseEntity<RouteDto> getRouteByRouteId(@PathVariable("routeId") Long routeId) {
		RouteDto routeDto = routeService.getRouteDetailsById(routeId);
		if (routeDto.getRouteId() == 0)
			throw new ResourceNotFoundException("No route matches this Id");
		else
			return new ResponseEntity<RouteDto>(routeService.getRouteDetailsById(routeId), HttpStatus.OK);
	}

}
