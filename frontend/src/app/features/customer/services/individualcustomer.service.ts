// individual-customer.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BaseService } from '../../../core/services/base.service';
import {
  AddRequest,
  UpdateRequest,
  GetByIdRequest,
  DeleteRequest,
} from '../models/request';
import {
  AddResponse,
  UpdateResponse,
  GetByIdResponse,
  GetAllResponse,
  DeleteResponse,
} from '../models/response';
import { environment } from '../../../../environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class IndividualCustomerService extends BaseService<
  GetAllResponse,
  GetByIdRequest,
  GetByIdResponse,
  AddRequest,
  AddResponse,
  UpdateRequest,
  UpdateResponse,
  DeleteRequest,
  DeleteResponse
> {
  constructor(http: HttpClient) {
    super(http, `${environment.apiBaseUrl}/individualcustomers`); // environment kullanılarak dinamik URL
  }

  // Ek özel metotlar gerekiyorsa buraya ekleyebilirsiniz.
}
