package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CabDto;
import com.example.demo.dto.RouteRequestDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.CabService;

@RestController
public class CabController {
	@Autowired
	CabService cabService;
	
	@GetMapping("/cabs/{routeId}")
	public ResponseEntity<List<CabDto>> getCabDetailsByRouteId(@PathVariable("routeId") Long routeId) {
		List<CabDto> cabDtoList = cabService.getAllCabDetailsByRouteId(routeId);
		if (cabDtoList.isEmpty())
			throw new ResourceNotFoundException("No cabs are availabe at this time");
		else
			return new ResponseEntity<List<CabDto>>(cabDtoList, HttpStatus.OK);
	}
	
	@GetMapping("/cabs/{routeId}/{status}")
	public ResponseEntity<List<CabDto>> getCabDetailsByRouteIdAndAvailability(@PathVariable("routeId")Long routeId,@PathVariable("status") String status) 
	{
		List<CabDto> cabDtoList = cabService.getCabDetailsByAvailability(status, routeId);
		if(cabDtoList.isEmpty())
			throw new ResourceNotFoundException("No cabs are availabe at this time in this route");
		else
			return new ResponseEntity<List<CabDto>>(cabDtoList,HttpStatus.OK);
	}
	
	@PostMapping("/cabs")
	public ResponseEntity<List<CabDto>> getCabsByLocation(@RequestBody RouteRequestDto routeRequestDto)
	{
		List<CabDto> cabDtoList = cabService.getCabDetailsByRoutes(routeRequestDto.getFromLocation(),routeRequestDto.getToLocation());
		if(cabDtoList.isEmpty())
			throw new ResourceNotFoundException("No cabs are availabe at this time with the requested route");
		else
			return new ResponseEntity<List<CabDto>>(cabDtoList,HttpStatus.OK);
		
	}
	
}

