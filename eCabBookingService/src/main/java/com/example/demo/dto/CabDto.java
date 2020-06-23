package com.example.demo.dto;



public class CabDto {
	Long cabId;
	Long cabNumber;
	String cabType;
	Double fare;
	public Long getCabNumber() {
		return cabNumber;
	}
	public void setCabNumber(Long cabNumber) {
		this.cabNumber = cabNumber;
	}
	public String getCabType() {
		return cabType;
	}
	public void setCabType(String cabType) {
		this.cabType = cabType;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	public Long getCabId() {
		return cabId;
	}
	public void setCabId(Long cabId) {
		this.cabId = cabId;
	}

}
