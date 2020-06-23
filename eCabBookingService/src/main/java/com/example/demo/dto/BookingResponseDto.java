package com.example.demo.dto;

import java.time.LocalDateTime;

public class BookingResponseDto {
	
	
	LocalDateTime bookingTime;
	String message;
	String fromLocation;
	String toLocation;
	Long cabNumber;
	public BookingResponseDto(long bookingId) {
		// TODO Auto-generated constructor stub
	}
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDateTime getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BookingResponseDto() {
		super();
	}
	public BookingResponseDto(String message) {
		super();
		this.message = message;
	}
	Long bookingId;
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
	public Long getCabNumber() {
		return cabNumber;
	}
	public void setCabNumber(Long cabNumber) {
		this.cabNumber = cabNumber;
	}
	

}
