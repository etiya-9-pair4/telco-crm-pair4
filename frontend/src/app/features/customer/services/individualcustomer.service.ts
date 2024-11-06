// individual-customer.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BaseService } from '../../../core/services/base.service';
import {
  AddRequest,
  UpdateRequest,
  GetByIdRequest,
  DeleteRequest,
  SearchIndividualCustomerRequestDto,
  AddIndividualCustomerRequestDto,
} from '../models/request';
import {
  AddResponse,
  UpdateResponse,
  GetByIdResponse,
  GetAllResponse,
  DeleteResponse,
  SearchIndividualCustomerResponseDto,
  AddIndividualCustomerResponseDto,
} from '../models/response';
import { environment } from '../../../../environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class IndividualCustomerService extends BaseService<
  GetAllResponse,
  GetByIdRequest,
  GetByIdResponse,
  AddIndividualCustomerRequestDto,
  AddIndividualCustomerResponseDto,
  UpdateRequest,
  UpdateResponse,
  DeleteRequest,
  DeleteResponse
> {
  constructor(http: HttpClient) {
    super(http, `${environment.apiBaseUrl}/individualcustomers`);
  }

  searchCustomers(
    searchDto: SearchIndividualCustomerRequestDto
  ): Observable<SearchIndividualCustomerResponseDto[]> {
    return this.http.post<SearchIndividualCustomerResponseDto[]>(
      `${this.baseUrl}/search`,
      searchDto
    );
  }
}
