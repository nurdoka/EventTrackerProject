package com.skilldistillery.appointmentlist.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "patient_name")
	private String patientName;
	
	@Column(name = "doctor_name")
	private String doctorName;

	@Column(name = "arrival_time")
	private LocalDateTime arrivalTime;
	
	@Column(name = "departure_time")
	private LocalDateTime departureTime;
	
	private String diagnose;
	
	private String prescription;
	
	public Appointment() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", patientName=" + patientName + ", doctorName=" + doctorName
				+ ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", diagnose=" + diagnose
				+ ", prescription=" + prescription + "]";
	}

}
