import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable, catchError, throwError } from 'rxjs';
import { Appointment } from '../models/appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  private url = environment.baseUrl + 'api/appointments';
  constructor(
    private http: HttpClient
  ) { }

  index(): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(this.url + '?sorted=true').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('AppointmentService.index(): error retrieving Appointments: ' + err)
        );
      })
    );
  }

}
