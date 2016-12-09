
import {Routes, RouterModule} from "@angular/router";

import {EmployeeComponent} from "./employee/employee.component";
import {NgModule} from "@angular/core";


export const routes: Routes = [
  { path: 'employees', component: EmployeeComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
