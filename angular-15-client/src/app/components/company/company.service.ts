import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Company } from './company.model';
import { Observable } from 'rxjs';
import { Job } from './job.model';

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

  postAJob(model: Job, company_id: string): Observable<Job>{
    return this.http.post<Job>(this.base_url + '/'+ company_id + '/job', model);
  }

  getAllJobs(){
    return this.http.get<Job[]>(this.base_url+ '/job/all')
  }

}
