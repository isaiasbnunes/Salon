import { Customer } from 'src/app/models/customer';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  url: string = environment.baseUrl + "/cliente";

  constructor(
    private http : HttpClient
  ) { }

  findAll():Observable<Customer[]>{
    return this.http.get<Customer[]>(this.url);
  }

  findById(id: any):Observable<Customer>{
    return this.http.get<Customer>(this.url +"/"+ id);
  }

  create(c: Customer):Observable<Customer>{
    return this.http.post<Customer>(this.url, c);
  }

  update(c: Customer):Observable<Customer>{
    return this.http.put<Customer>(this.url +'/'+ c.id , c);
  }

  delete(id: any){
    return this.http.delete<void>(this.url +'/'+id);
  }
}
