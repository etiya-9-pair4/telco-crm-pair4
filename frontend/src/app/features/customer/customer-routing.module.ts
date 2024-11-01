import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateCustomerComponent } from './pages/create-customer/create-customer.component';
import { MainLayoutComponent } from '../../shared/layout/main-layout/main-layout.component';
import { SearchCustomerComponent } from './pages/search-customer/search-customer.component';

const routes: Routes = [
  {
    path: '',
    component: MainLayoutComponent,
    children: [
      {
        path: 'create',
        component: CreateCustomerComponent,
      },
      {
        path: '',
        component: SearchCustomerComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CustomerRoutingModule {}
