package com.skilldistillery.appointmentlist.services;

import java.util.List;

import com.skilldistillery.appointmentlist.entities.Appointment;

public interface AppointmentService {

	List<Appointment> getAllAppointments();
	Appointment getAppointmentById(int appId);
	Appointment createAppointment(Appointment app);
	Appointment updateAppointmentById(Appointment appo,int appoId);
}
