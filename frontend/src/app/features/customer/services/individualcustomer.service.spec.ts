import { TestBed } from '@angular/core/testing';

import { IndividualCustomerService } from './individualcustomer.service';

describe('CustomerService', () => {
  let service: IndividualCustomerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IndividualCustomerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
