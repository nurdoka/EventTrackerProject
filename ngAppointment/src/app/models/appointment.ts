export class Appointment {
  id: number;
  patientName: string;
  doctorName: string;
  arrivalTime: string;
  departureTime: string;
  diagnose: string;
  prescription: string;

  constructor(
    id: number = 0,
    patientName: string = '',
    doctorName: string = '',
    arrivalTime: string = '',
    departureTime: string = '',
    diagnose: string = '',
    prescription: string = ''
  ){
  this.id = id;
  this.patientName = patientName;
  this.doctorName = doctorName;
  this.arrivalTime = arrivalTime;
  this.departureTime = departureTime;
  this.diagnose = diagnose;
  this.prescription = prescription;
  }
}
