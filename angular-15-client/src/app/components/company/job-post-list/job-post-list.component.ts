import { Component, OnInit } from '@angular/core';
import { CompanyService } from '../company.service';
import { Job } from '../job.model';

@Component({
  selector: 'app-job-post-list',
  templateUrl: './job-post-list.component.html',
  styleUrls: ['./job-post-list.component.css']
})
export class JobPostListComponent implements OnInit {

  jobs:Job[]=[];
  constructor(private companyService: CompanyService){

  }

  ngOnInit(): void {
      this.companyService.getAllJobs()
      .subscribe(r=> this.jobs = r);
  }

}
