import { inject } from '@angular/core';
import { CanMatchFn, Router } from '@angular/router';
import { AuthService } from '../Service/auth-service';

export const adminGuardGuard: CanMatchFn = (route, segments) => {

  const authService=inject(AuthService);
  const router=inject(Router);
  if(authService.isAdmin()){
    return true;
  }
  router.createUrlTree(['/login']);
  return true;
};
