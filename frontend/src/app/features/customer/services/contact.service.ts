// contact.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment.development';
import { ContactRequest } from '../models/request';
import { ContactResponse } from '../models/response';
import { BaseService } from '../../../core/services/base.service';

@Injectable({
  providedIn: 'root',
})
export class ContactService extends BaseService<
  ContactResponse, // TGetAllResponse tipine karşılık
  number, // TGetByIdRequest tipine karşılık (örneğin ID'yi number olarak alabiliriz)
  ContactResponse, // TGetByIdResponse tipine karşılık
  ContactRequest, // TAddRequest tipine karşılık
  ContactResponse, // TAddResponse tipine karşılık
  ContactRequest, // TUpdateRequest tipine karşılık
  ContactResponse, // TUpdateResponse tipine karşılık
  number, // TDeleteRequest tipine karşılık (örneğin ID'yi number olarak alabiliriz)
  ContactResponse // TDeleteResponse tipine karşılık
> {
  constructor(http: HttpClient) {
    super(http, `${environment.apiBaseUrl}/contact`);
  }
}
