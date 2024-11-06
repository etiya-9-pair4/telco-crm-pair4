// address.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment.development';
import { AddressRequest } from '../models/request';
import { AddressResponse } from '../models/response/AddressResponse';
import { BaseService } from '../../../core/services/base.service';

@Injectable({
  providedIn: 'root',
})
export class AddressService extends BaseService<
  AddressResponse, // TGetAllResponse tipine karşılık
  number, // TGetByIdRequest tipine karşılık (örneğin ID'yi number olarak alabiliriz)
  AddressResponse, // TGetByIdResponse tipine karşılık
  AddressRequest, // TAddRequest tipine karşılık
  AddressResponse, // TAddResponse tipine karşılık
  AddressRequest, // TUpdateRequest tipine karşılık
  AddressResponse, // TUpdateResponse tipine karşılık
  number, // TDeleteRequest tipine karşılık (örneğin ID'yi number olarak alabiliriz)
  AddressResponse // TDeleteResponse tipine karşılık
> {
  constructor(http: HttpClient) {
    super(http, `${environment.apiBaseUrl}/address`);
  }
}
