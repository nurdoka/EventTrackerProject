package com.skilldistillery.appointmentlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.appointmentlist.entities.Appointment;
import com.skilldistillery.appointmentlist.repositories.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepo;

	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentRepo.findAll();
	}

	@Override
	public Appointment getAppointmentById(int appId) {
		return appointmentRepo.findById(appId);
	}

}
