import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { User } from '../user.model';
import { UtilService } from 'src/app/util.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {

  userFormGroup: FormGroup;

  constructor(private  userService: UserService, private utilService: UtilService) {
    this.userFormGroup = new FormGroup({
      firstName: new FormControl('', [Validators.required]),
      lastName: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      dob: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      mobile: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
      about: new FormControl('', [Validators.required])
    })
  }

  saveUser(){
    this.userService.saveUser(<User>this.userFormGroup.value)
    .subscribe(r=>{
      this.utilService.showSuccess("Success","User information is registered!");
    })
  }

}
