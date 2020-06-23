package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookingDao;
import com.example.demo.dao.CabDao;
import com.example.demo.dao.UserDao;
import com.example.demo.dto.BookingRequestDto;
import com.example.demo.dto.BookingResponseDto;
import com.example.demo.dto.RouteDto;
import com.example.demo.model.Booking;
import com.example.demo.model.Cab;
import com.example.demo.model.User;
import com.example.demo.service.BookingService;
import com.example.demo.service.RouteService;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingDao bookingDao;
	@Autowired
	CabDao cabDao;
	@Autowired
	RouteService routeService;
	@Autowired
	UserDao userDao;

	@Override
	public BookingResponseDto confirmBooking(BookingRequestDto bookingRequestDto, Long routeId) {

		
		Optional<Cab> cab1 = cabDao.findByRouteIdAndCabId(routeId, bookingRequestDto.getCabId());
		Optional<User> user = userDao.findById(bookingRequestDto.getUserId());
		String status = "AVAILABLE";
		Optional<List<Cab>> cab = cabDao.findByStatusAndRouteId(status, routeId);
		if (user.isPresent()) {
			if (cab1.isPresent()&&cab.isPresent()) {
				BookingResponseDto bookingResponseDto = new BookingResponseDto();
				Booking booking = new Booking();
				BeanUtils.copyProperties(bookingRequestDto, booking);
				booking.setBookingTime(LocalDateTime.now());
				booking.setRouteId(routeId);
				bookingDao.save(booking);
				BeanUtils.copyProperties(booking, bookingResponseDto);
				RouteDto route = routeService.getRouteDetailsById(routeId);
				bookingResponseDto.setFromLocation(route.getFromLocation());
				bookingResponseDto.setToLocation(route.getToLocation());
				bookingResponseDto.setCabNumber(cab1.get().getCabNumber());
				bookingResponseDto.setMessage("Your booking is confirmed!!!");
				return bookingResponseDto;
			} else
				return new BookingResponseDto("Booking not confirmed");
		} else
			return new BookingResponseDto("User not found");
	}

}
