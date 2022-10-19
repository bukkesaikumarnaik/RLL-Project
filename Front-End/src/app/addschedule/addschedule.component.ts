import { Component, OnInit } from '@angular/core';
import { Schedule } from '../schedule';
import { ScheduleService } from '../schedule.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addschedule',
  templateUrl: './addschedule.component.html',
  styleUrls: ['./addschedule.component.scss']
})
export class AddscheduleComponent implements OnInit {

  schedule: Schedule[] = [];

   constructor(private scheduleService: ScheduleService,
    private router: Router) { }

    ngOnInit(): void {
      this.getSchedules();
    }

    private getSchedules(){
      this.scheduleService.getScheduleList().subscribe(data => {
        this.schedule = data;
      });
    }

    scheduleDetails(emp_id: number){
      this.router.navigate(['schedule-details', emp_id]);
    }
  
    updateSchedule(emp_id: number){
      this.router.navigate(['update-schedule', emp_id]);
    }
  
    deleteSchedule(emp_id: number){
      this.scheduleService.deleteSchedule(emp_id).subscribe( data => {
        console.log(data);
        this.getSchedules();
      })
      return location.reload();
    }
    
    logout() {
      localStorage.removeItem("token");
      this.router.navigate(['/header']);
    }
}
