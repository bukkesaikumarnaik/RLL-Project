import { Component, OnInit } from '@angular/core';
import { Schedule } from '../schedule';
import { ScheduleService } from '../schedule.service';
import { Router, ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-schedule',
  templateUrl: './update-schedule.component.html',
  styleUrls: ['./update-schedule.component.scss']
})
export class UpdateScheduleComponent implements OnInit {

  emp_id!: number;
  schedule: Schedule = new Schedule;
  constructor(private scheduleService:ScheduleService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.emp_id = this.route.snapshot.params['emp_id'];

    this.scheduleService.getScheduleById(this.emp_id).subscribe(data => {
      this.schedule = data;
      
    }, error => console.log(error));
  }

  onSubmit(){
    this.scheduleService.updateSchedule(this.emp_id, this.schedule).subscribe( data =>{
      Swal.fire("Schedule Updated Successfully")
      this.goToscheduleList();
    }
    , error => console.log(error));
  }

  goToscheduleList(){
    this.router.navigate(['../addschedule']);
  }


}
