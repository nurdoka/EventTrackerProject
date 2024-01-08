package com.skilldistillery.appointmentlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.appointmentlist.entities.Appointment;

public interface AppointmentRepository  extends JpaRepository<Appointment, Integer>{
	
	Appointment findById(int appId);
}
