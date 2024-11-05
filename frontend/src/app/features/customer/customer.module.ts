import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { CreateCustomerComponent } from './pages/create-customer/create-customer.component';
import { SearchCustomerComponent } from './pages/search-customer/search-customer.component';
import { ReactiveFormsModule } from '@angular/forms';
import { IndividualCustomerService } from './services/individualcustomer.service';

@NgModule({
  declarations: [CreateCustomerComponent, SearchCustomerComponent],
  imports: [CommonModule, CustomerRoutingModule, ReactiveFormsModule],
  providers: [IndividualCustomerService],
})
export class CustomerModule {}
