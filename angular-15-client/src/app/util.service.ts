import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
@Injectable({
  providedIn: 'root'
})
export class UtilService {
  constructor(private toastr: ToastrService) {}

  showSuccess(title: string, msg: string) {
    this.toastr.success(msg, title, {disableTimeOut: false});
  }
}
