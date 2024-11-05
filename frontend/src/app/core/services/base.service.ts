// base.service.ts
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export abstract class BaseService<
  TGetAllResponse,
  TGetByIdRequest,
  TGetByIdResponse,
  TAddRequest,
  TAddResponse,
  TUpdateRequest,
  TUpdateResponse,
  TDeleteRequest,
  TDeleteResponse
> {
  protected baseUrl: string;

  constructor(protected http: HttpClient, baseUrl: string) {
    this.baseUrl = baseUrl;
  }

  // Get all records
  getAll(): Observable<TGetAllResponse[]> {
    return this.http.get<TGetAllResponse[]>(`${this.baseUrl}`);
  }

  // Get a single record by ID
  getById(request: TGetByIdRequest): Observable<TGetByIdResponse> {
    return this.http.post<TGetByIdResponse>(`${this.baseUrl}/getById`, request);
  }

  // Create a new record
  add(request: TAddRequest): Observable<TAddResponse> {
    return this.http.post<TAddResponse>(this.baseUrl, request);
  }

  // Update an existing record
  update(request: TUpdateRequest): Observable<TUpdateResponse> {
    return this.http.put<TUpdateResponse>(`${this.baseUrl}`, request);
  }

  // Delete a record
  delete(request: TDeleteRequest): Observable<TDeleteResponse> {
    return this.http.request<TDeleteResponse>('DELETE', `${this.baseUrl}`, {
      body: request,
    });
  }
}
