package com.ola.in.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ola.in.entity.Booking;


@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long>{
	@Query("Select b from Booking b where b.customerItem.customer.userId= ?1")
	List<Booking> findByCustomerDetails(String custId);
	List<Booking> findByBookingDate(LocalDate date);

}
