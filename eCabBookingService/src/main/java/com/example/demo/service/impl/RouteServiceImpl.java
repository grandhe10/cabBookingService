package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RouteDao;
import com.example.demo.dto.RouteDto;
import com.example.demo.model.Routes;
import com.example.demo.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {
	@Autowired
	RouteDao routeDao;

	@Override
	public List<RouteDto> getAllRoutes() {
		List<Routes> routes = routeDao.findAll();
		List<RouteDto> routesDtoList = new ArrayList<RouteDto>();
		routes.forEach(route -> routesDtoList.add(getRouteDto(route)));
		return routesDtoList;
	}

	private RouteDto getRouteDto(Routes route) {
		RouteDto routeDto = new RouteDto();
		BeanUtils.copyProperties(route, routeDto);
		return routeDto;
	}

	@Override
	public RouteDto getRouteDetailsById(Long routeId) {
		RouteDto routeDto = new RouteDto();
		Optional<Routes> routes = routeDao.findById(routeId);
		if (routes.isPresent()) {
			BeanUtils.copyProperties(routes.get(), routeDto);
			return routeDto;

		} else
			return new RouteDto(0L);
	}

	@Override
	public List<RouteDto> getRouteDetailsByLocation(String fromLocation, String toLocation) {
		Optional<List<Routes>> routes = routeDao.findByFromLocationContainingAndToLocationContaining(fromLocation, toLocation);
		List<RouteDto> routeDtoList = new ArrayList<>();
		if (routes.isPresent()) {

			routeDtoList = routes.get().stream().map(route -> getRouteDto(route)).collect(Collectors.toList());
			return routeDtoList;

		}
		return routeDtoList;
	}

	public RouteDto getRouteDetailsByRouteTd(Long routeId)
	{
		Optional<Routes> route = routeDao.findByRouteId(routeId);
		RouteDto routeDto = new RouteDto();
		
		if(route.isPresent())
		{
			BeanUtils.copyProperties(route, routeDto);
			return routeDto;
		}
		else
			return new RouteDto(0L);
	}
	
}
