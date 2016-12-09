import {Employee} from "./employee";
import {Component, OnInit} from "@angular/core";
import {EmployeeService} from "./employee.service";

@Component({
  moduleId: module.id.toString(),
  selector: 'employee-tag',
  templateUrl: 'employee.component.html',
  styleUrls: [ 'employee.component.css' ],
  providers: [ EmployeeService ]
})

export class EmployeeComponent {

  employees: Employee[];

  constructor(private service: EmployeeService){}

   getAllEmployees():void{
   this.service.getAll().then(employees => this.employees = employees);
   }



 /* getAllEmployees():void {
    this.service.getAll().subscribe(employees => this.employees = employees);


  }*/
}
