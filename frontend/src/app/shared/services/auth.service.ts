import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment.development';
import { TokenResponse } from '../models/auth/tokenResponse';
import { LoginRequest } from '../models/auth/loginRequest';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  controllerUrl: string = `${environment.MS_V1_API_URL}/auth`;

  constructor(private httpClient: HttpClient) {}

  login(loginRequest: LoginRequest): Observable<TokenResponse> {
    return this.httpClient.post<TokenResponse>(
      `${this.controllerUrl}/login`,
      loginRequest
    );
  }
}
