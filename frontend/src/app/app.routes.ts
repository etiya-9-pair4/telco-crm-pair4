import { Routes } from '@angular/router';

export const routes: Routes = [
  // {
  //   path: '',
  //   loadChildren: () =>
  //     import('../app/shared/shared.module').then((m) => m.SharedModule),
  // },
  {
    path: 'login',
    loadChildren: () =>
      import('./shared/shared.module').then((m) => m.SharedModule),
  },
  {
    path: '',
    loadChildren: () =>
      import('../app/features/customer/customer.module').then(
        (m) => m.CustomerModule
      ),
  },
];
