package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CabDao;
import com.example.demo.dao.RouteDao;
import com.example.demo.dto.CabDto;
import com.example.demo.model.Cab;
import com.example.demo.model.Routes;
import com.example.demo.service.CabService;
@Service
public class CabServiceImpl implements CabService{
	@Autowired
	CabDao cabDao;
	@Autowired
	RouteDao routeDao;
	@Override
	public List<CabDto> getAllCabDetailsByRouteId(Long routeId) {
		Optional<List<Cab>> cabs = cabDao.findAllByRouteId(routeId);
		List<CabDto> cabDtoList = new ArrayList<CabDto>();
		if(cabs.isPresent())
		{
			return cabs.get().stream().map(cab->getCabDto(cab)).collect(Collectors.toList());
		}
		else
			return cabDtoList;
		
	}
	
	
	private CabDto getCabDto(Cab cab)
	{
		CabDto cabDto = new CabDto();
		BeanUtils.copyProperties(cab, cabDto);
		
		cabDto.setCabType(cab.getCabType());
		
		return cabDto;
	}

	@Override
	public List<CabDto> getCabDetailsByAvailability(String status, Long routeId) {
		Optional<List<Cab>> cabs = cabDao.findByStatusAndRouteId(status, routeId);
		List<CabDto> cabDtoList = new ArrayList<CabDto>();
		if(cabs.isPresent())
		{
			return cabs.get().stream().map(cab->getCabDto(cab)).collect(Collectors.toList());
		}
		else
			return cabDtoList;
		}


	@Override
	public List<CabDto> getCabDetailsByRoutes(String fromLocation, String toLocation) {
		Optional<List<Routes>> routes = routeDao.findByFromLocationAndToLocation(fromLocation, toLocation);
		List<CabDto> cabDtoList = new ArrayList<CabDto>();
		if(routes.isPresent())
		{
			String status = "AVAILABLE";
			Optional<List<Cab>> cabs = cabDao.findByStatusAndRouteId(status,routes.get().get(0).getRouteId());
			if(cabs.isPresent())
			{
				return cabs.get().stream().map(cab->getCabDto(cab)).collect(Collectors.toList());
			}
			return cabDtoList;
	}
		return cabDtoList;
	
}
}