package com.skilldistillery.appointmentlist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.appointmentlist.entities.Appointment;
import com.skilldistillery.appointmentlist.services.AppointmentService;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping("appointments")
	public List<Appointment> showAllAppointments() {
		return appointmentService.getAllAppointments();
	}

	@GetMapping("appointments/{appId}")
	public Appointment showAppointmentById(@PathVariable("appId") int appId) {
		return appointmentService.getAppointmentById(appId);
	}

	@PostMapping("appointments")
	public Appointment createAppointment(@RequestBody Appointment app) {
		return appointmentService.createAppointment(app);
	}

	@PutMapping("appointments/{appoId}")
	public Appointment updateAppointment(@RequestBody Appointment appo, @PathVariable("appoId") int appoId) {
		return appointmentService.updateAppointmentById(appo, appoId);
	}

	@DeleteMapping("appointments/{appoId}")
	public void deleteAppointment(@PathVariable("appoId") int appoId,HttpServletResponse response) {
		try {
			if (appointmentService.deleteAppointmentById(appoId)) {
				response.setStatus(204);
			} else {
				response.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
		}
	}
}
