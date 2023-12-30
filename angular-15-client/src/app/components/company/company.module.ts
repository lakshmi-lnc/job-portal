import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CompanyRoutingModule } from './company-routing.module';
import { CompanyFormComponent } from './company-form/company-form.component';
import { JobPostFormComponent } from './job-post-form/job-post-form.component';
import { CompanyListComponent } from './company-list/company-list.component';
import { JobPostListComponent } from './job-post-list/job-post-list.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    CompanyFormComponent,
    JobPostFormComponent,
    CompanyListComponent,
    JobPostListComponent
  ],
  imports: [
    CommonModule,
    CompanyRoutingModule,
    ReactiveFormsModule,

  ]
})
export class CompanyModule { }
