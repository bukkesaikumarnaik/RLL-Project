import { Component, OnInit } from '@angular/core';
import { Salary } from '../salary';
import { SalaryService } from '../salary.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addsalary',
  templateUrl: './addsalary.component.html',
  styleUrls: ['./addsalary.component.scss']
})
export class AddsalaryComponent implements OnInit {

  salary : Salary[] = [];

   constructor(private salaryService: SalaryService,
    private router: Router) { }

    ngOnInit(): void {
      this.getSalarys();
    }

    private getSalarys(){
      this.salaryService.getSalaryList().subscribe(data => {
        this.salary = data;
      });
    }

    salaryDetails(emp_id: number){
      this.router.navigate(['salary-details', emp_id]);
    }
  
    updateSalary(emp_id: number){
      this.router.navigate(['update-salary', emp_id]);
    }
  
    deleteSalary(emp_id: number){
      
      this.salaryService.deleteSalary(emp_id).subscribe( data => {
        console.log(data);
        this.getSalarys();
      })
      return location.reload();
    }

    logout() {
      localStorage.removeItem("token");
      this.router.navigate(['/header']);
    }
}
