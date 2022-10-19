import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse} from '@angular/common/http'
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { Observable } from 'rxjs';
import { Schedule } from './schedule'

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {
  getAddSchedule() {
    throw new Error('Method not implemented.');
  }
  url: any;

  private baseURL = "http://localhost:8088/api/v1/";  

  constructor(private httpClient:HttpClient) { }

  getScheduleList(): Observable<Schedule[]>{
    return this.httpClient.get<Schedule[]>(`${this.baseURL}`+`/schedules`);
  }
  createSchedule(schedule: Schedule): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`+`/schedules`, schedule);
  }
  getScheduleById(emp_id: number): Observable<Schedule>{
    return this.httpClient.get<Schedule>(`${this.baseURL}/schedules/${emp_id}`);
  }
  updateSchedule(emp_id: number, schedule: Schedule): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/schedules/${emp_id}`, schedule);
  }
  deleteSchedule(emp_id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}`+`schedules/${emp_id}`);
  }
  getScheduleData(){
    return this.httpClient.get(`${this.url}/api/Addschedule`).pipe(
      catchError(this.errorHandle)
    );
  }
  errorHandle(error:HttpErrorResponse){
   
    return throwError(error.message || 'server error');
  }
}