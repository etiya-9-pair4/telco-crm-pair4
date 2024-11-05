import { inject } from '@angular/core';
import { StorageService } from './../services/storage.service';
import { HttpInterceptorFn } from '@angular/common/http';
import { catchError, finalize } from 'rxjs';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  // req => request (giden istek)
  // next => istedği devam ettirecek olan fonksiyon.

  //fn bazlı di
  const storageService = inject(StorageService);

  req = req.clone({
    setHeaders: {
      Authorization: `Bearer ${storageService.get('token')}`,
      'Accept-Language': 'en',
    },
  });
  return next(req).pipe(
    finalize(() => {
      console.log('inteceptor isteğin bittiğini yakaladı...');
    }),
    catchError((err) => {
      //global hata yönetimi
      console.log('interceptor hata yakaladı:', err);
      throw err;
    })
  );
};
