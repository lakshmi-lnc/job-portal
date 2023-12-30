import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Company } from './company.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  base_url = 'api/companies';

  constructor(private http: HttpClient) { }

  saveCompany(model: Company): Observable<Company> {
    return this.http.post<Company>(this.base_url, model);
  }
  getAllCompanies() {
    return this.http.get<Company[]>(this.base_url);
  }

}
