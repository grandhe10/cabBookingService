package com.example.demo.service;

import com.example.demo.dto.BookingRequestDto;
import com.example.demo.dto.BookingResponseDto;

public interface BookingService {

	
	public BookingResponseDto confirmBooking(BookingRequestDto bookingRequestDto, Long routeId);
	
}
