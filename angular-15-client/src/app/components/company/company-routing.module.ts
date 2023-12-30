import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompanyFormComponent } from './company-form/company-form.component';
import { JobPostFormComponent } from './job-post-form/job-post-form.component';
import { CompanyListComponent } from './company-list/company-list.component';
import { JobPostListComponent } from './job-post-list/job-post-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'new-company', pathMatch: 'full' },
  { path: 'new-company', component: CompanyFormComponent },
  { path:'new-job', component: JobPostFormComponent},
  {path:'job-post-list', component: JobPostListComponent},
  {path:'list', component: CompanyListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CompanyRoutingModule { }
