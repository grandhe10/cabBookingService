package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookingRequestDto;
import com.example.demo.dto.BookingResponseDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	BookingService bookingService;

	@PostMapping("/bookings/{routeId}")
	public ResponseEntity<BookingResponseDto> confirmBooking(@RequestBody BookingRequestDto bookingRequestDto,
			@PathVariable("routeId") Long routeId) {
		BookingResponseDto bookingResponseDto = bookingService.confirmBooking(bookingRequestDto, routeId);
		if (bookingResponseDto.getMessage().equalsIgnoreCase("Booking not confirmed"))
			throw new ResourceNotFoundException("Booking Cannot be done due to inavailabiltity");
		if (bookingResponseDto.getMessage().equalsIgnoreCase("User not found"))
			throw new ResourceNotFoundException("User not found");
		else

			return new ResponseEntity<BookingResponseDto>(bookingService.confirmBooking(bookingRequestDto, routeId),
					HttpStatus.OK);
	}
}
