import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  base_url = 'api/users';

  constructor(private http: HttpClient) { }

  saveUser(model: User): Observable<User> {
    return this.http.post<User>(this.base_url, model);
  }
  getAllUsers() {
    return this.http.get<User[]>(this.base_url);
  }
}
