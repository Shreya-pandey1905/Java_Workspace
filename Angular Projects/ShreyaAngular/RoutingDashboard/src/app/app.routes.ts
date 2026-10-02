import { Routes } from '@angular/router';
import { Home } from './Pages/home/home';
import { Login } from './Pages/login/login';
import { Dashboard } from './Pages/dashboard/dashboard';
import { Admin } from './Pages/admin/admin';
import { EditProfile } from './Pages/edit-profile/edit-profile';
import { dashboardGuard } from './guards/dashboard-guard';
import { editProfileGuard } from './guards/edit-profile-guard';
import { adminGuardGuard } from './guards/admin-guard-guard';

export const routes: Routes = [
    {path:'',component:Home},
    {path:'login',component:Login},
    {path:'dashboard',component:Dashboard,canActivate:[dashboardGuard]},    
  {
  path: 'admin',
  canMatch: [adminGuardGuard],
  loadComponent: () => import('./Pages/admin/admin').then(m => m.Admin)
},



];
