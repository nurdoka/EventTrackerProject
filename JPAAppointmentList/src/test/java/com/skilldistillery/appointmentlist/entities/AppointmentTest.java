package com.skilldistillery.appointmentlist.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.appointmentlist.entities.Appointment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import net.bytebuddy.matcher.ElementMatcher;

class AppointmentTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Appointment appointment;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAAppointmentList");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		appointment = em.find(Appointment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		appointment = null;
	}

	@Test
	void test_appointment_entity_mapping() {
		assertNotNull(appointment);
		assertEquals("ibuprofen", appointment.getPrescription());
		assertEquals("2023-01-15 10:30:00", appointment.getArrivalTime());
	}
	
	@Test
	void test_appointment_departure_time_mapping() {
		assertEquals("2023-01-15 11:30:00", appointment.getDepartureTime());
	}

}
