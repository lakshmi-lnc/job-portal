import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CompanyService } from '../company.service';
import { UtilService } from 'src/app/util.service';

@Component({
  selector: 'app-job-post-form',
  templateUrl: './job-post-form.component.html',
  styleUrls: ['./job-post-form.component.css']
})
export class JobPostFormComponent implements OnInit {

  jobForm : FormGroup;

  constructor(private companyService: CompanyService, private utilService: UtilService){
    this.jobForm = new FormGroup({
      title: new FormControl('',[Validators.required]),
      experience: new FormControl('', [Validators.required]),
      location: new FormControl('', [Validators.required]),
      department: new FormControl('', [Validators.required]),
      salaryRange: new FormControl('', [Validators.required]),
      employmentType: new FormControl('', [Validators.required]),
      skills: new FormControl('', [Validators.required]),
      hrName: new FormControl('', [Validators.required]),
      hrEmail: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      education: new FormControl('', [Validators.required])
    });
  }

  ngOnInit(): void {

  }

  postJob(){
this.companyService.postAJob(this.jobForm.value, '2')
.subscribe(r=>{
  this.utilService.showSuccess("Success","Your Job information is posted successfully!");
})
  }

}
