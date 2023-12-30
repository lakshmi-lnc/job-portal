import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CompanyService } from '../company.service';
import { Company } from '../company.model';
import { UtilService } from 'src/app/util.service';

@Component({
  selector: 'app-company-form',
  templateUrl: './company-form.component.html',
  styleUrls: ['./company-form.component.css']
})
export class CompanyFormComponent implements OnInit {

  companyForm: FormGroup;
  constructor(private companyService: CompanyService, private utilService: UtilService){
    this.companyForm = new FormGroup({
      companyName: new FormControl('',[Validators.required]),
      type: new FormControl('', [Validators.required]),
      foundedOn: new FormControl('', [Validators.required]),
      companySize: new FormControl('', [Validators.required]),
      website: new FormControl('', [Validators.required]),
      headquarter: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
      about: new FormControl('', [Validators.required])
    });
  }

  ngOnInit(): void {

  }

  saveCompany(){
    this.companyService.saveCompany(<Company>this.companyForm.value)
    .subscribe(r=>{
      this.utilService.showSuccess("Success","Company information is added!");
    })
  }


}
