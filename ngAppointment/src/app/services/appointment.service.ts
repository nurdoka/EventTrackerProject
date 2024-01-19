import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  private url = environment.baseUrl + 'api/appointments';
  constructor(
    private http: HttpClient
  ) { }
}
