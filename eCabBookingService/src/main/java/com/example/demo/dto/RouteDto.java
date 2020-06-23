package com.example.demo.dto;

public class RouteDto {
	Long routeId;
	String fromLocation;
	String toLocation;
	public RouteDto(long l) {
		// TODO Auto-generated constructor stub
	}
	public RouteDto() {
		// TODO Auto-generated constructor stub
	}
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	

}
