package com.skilldistillery.appointmentlist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.appointmentlist.entities.Appointment;
import com.skilldistillery.appointmentlist.services.AppointmentService;

@RestController
@RequestMapping("api")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping("appointments")
	public List<Appointment> showAllAppointments(){
		return appointmentService.getAllAppointments();
	}
	
	@GetMapping("appointments/{appId}")
	public Appointment showAppointmentById(@PathVariable("appId") int appId){
		return appointmentService.getAppointmentById(appId);
	}
}
