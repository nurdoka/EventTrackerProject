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
  selected: Appointment | null = null;
  editAppo: Appointment | null = null;
  newAppo: Appointment | null = null;

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

  updateAppointment(appo:Appointment):void{
    this.appointmentService.update(appo).subscribe({
      next: (result) => {
        this.loadAppointments();
        this.selected = this.editAppo;
        this.editAppo = null;
      }
    });
  }
  setEditAppo(){
    this.editAppo = Object.assign({}, this.selected);
  }

  addAppointment(appo:Appointment):void{
    this.appointmentService.create(appo).subscribe({
      next: (result) => {
        this.newAppo = new Appointment();
        this.newAppo = null;
        this.loadAppointments();
      },
      error: (problem) =>{
        console.error('AppointmentComponent.addTodo(): error creating Appointment');
        console.error(problem);
      }
    });
  }
  assignNewAppo():void{
    this.newAppo = new Appointment();
  }

}
