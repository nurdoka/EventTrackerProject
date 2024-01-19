import { CommonModule } from '@angular/common';
import { Appointment } from './../../models/appointment';
import { AppointmentService } from './../../services/appointment.service';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  appointments: Appointment[] = [];

  constructor(
    private appointmentService:AppointmentService
  ){}

  ngOnInit():void{
    this.loadAppointments();
  }

  loadAppointments():void {
    this.appointmentService.index().subscribe(
      {
        next: (appointmentList) => {
          this.appointments = appointmentList;
        },
        error: (problem) => {
          console.error('AppointmentListHttpComponent.loadAppointments(): error loading appointments:');
          console.error(problem);
        }
      }
    );
  }


}
