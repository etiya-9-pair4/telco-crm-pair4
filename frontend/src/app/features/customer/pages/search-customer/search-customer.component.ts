import { IndividualCustomerService } from './../../services/individualcustomer.service';
import { Component } from '@angular/core';
import { GetAllResponse } from '../../models/response';

@Component({
  selector: 'app-search-customer',
  templateUrl: './search-customer.component.html',
  styleUrl: './search-customer.component.scss',
})
export class SearchCustomerComponent {
  customers: GetAllResponse[] = [];

  constructor(private IndividualCustomerService: IndividualCustomerService) {}

  ngOnInit(): void {
    this.fetchAllCustomers();
  }

  fetchAllCustomers(): void {
    this.IndividualCustomerService.getAll().subscribe({
      next: (response: GetAllResponse[]) => {
        this.customers = response;
        console.log('All customers:', response);
      },
      error: (err) => console.error(err),
    });
  }
}
