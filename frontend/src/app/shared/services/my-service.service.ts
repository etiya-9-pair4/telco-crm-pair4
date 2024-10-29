// todo.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' }) // Servisi tüm uygulamada kullanılabilir hale getir
export class TodoService {
  private baseUrl = 'BASE_URL';

  constructor(private http: HttpClient) {}

  get(): Observable<Response[]> {
    return this.http.get<GetResponse[]>(this.baseUrl);
  }

  add(todo: CreateRequest): Observable<CreateResponse> {
    return this.http.post<CreateResponse>(this.baseUrl, todo);
  }

  updateTodo(todo: UpdateRequest): Observable<UpdateResponse> {
    const url = `${this.baseUrl}/${todo.id}`;
    return this.http.put<UpdateResponse>(url, todo);
  }

  delete(todoId: number): Observable<any> {
    const url = `${this.baseUrl}/${todoId}`;
    return this.http.delete(url);
  }

  getById(id: string): Observable<GetListResponse[]> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<GetListResponse[]>(url);
  }
}
