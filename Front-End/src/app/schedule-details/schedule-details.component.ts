import { Component, OnInit } from '@angular/core';
import { Schedule } from '../schedule';
import { ScheduleService } from '../schedule.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-schedule-details',
  templateUrl: './schedule-details.component.html',
  styleUrls: ['./schedule-details.component.scss']
})
export class ScheduleDetailsComponent implements OnInit {

  emp_id!: number;
  schedule!: Schedule;
  constructor(private route: ActivatedRoute, private scheduleService: ScheduleService) { }

  ngOnInit(): void {
    this.emp_id = this.route.snapshot.params['emp_id'];
    this.schedule = new Schedule();
    this.scheduleService.getScheduleById(this.emp_id).subscribe( data => {
      this.schedule = data;
    });
  }

}
