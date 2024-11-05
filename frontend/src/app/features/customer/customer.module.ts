import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { CreateCustomerComponent } from './pages/create-customer/create-customer.component';
import { SearchCustomerComponent } from './pages/search-customer/search-customer.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [CreateCustomerComponent, SearchCustomerComponent],
  imports: [CommonModule, CustomerRoutingModule, ReactiveFormsModule],
})
export class CustomerModule {}
