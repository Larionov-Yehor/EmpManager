
import {Injectable} from "@angular/core";
import { Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/toPromise';
import {Employee} from "./employee";



@Injectable()
export class EmployeeService {
  private employeeUrl = '/api/employees/';

  constructor(private http: Http ) {  }

  getAll(): Promise<Employee[]> {
    return this.http.get(this.employeeUrl)
      .toPromise()
      .then(response => response.json() as Employee[])
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

 /* getAll(): Observable<Employee[]> {
    return this.http.get(this.employeeUrl)
        .toArray(this.extractData);
/!*      .catch(this.handleError);*!/
  }

  private extractData(res: Response){
    let body = res.json();
    return body.data || {}

  }*/
 /* private handleError (error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }*/

}
