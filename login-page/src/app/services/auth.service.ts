import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginResponse } from '../types/login-response.type';
import { tap } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  public apiUrl = 'http://localhost:8080/user';

  login(name: string, password: string){
    return this.httpClient.post<LoginResponse>(`${this.apiUrl}/login`, {name, password}).pipe(
      tap((value) => {
        localStorage.setItem('token', value.token);
        localStorage.setItem('name', value.name);
        localStorage.setItem('idUser', value.idUser.toString());
      }))
  }
}
