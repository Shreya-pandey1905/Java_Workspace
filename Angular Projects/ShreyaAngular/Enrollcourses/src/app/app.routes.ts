import { Routes } from '@angular/router';
import { Login } from './Pages/login/login';
import { EditProfile } from './Pages/edit-profile/edit-profile';
import { Courses } from './Pages/courses/courses';
import { adminCoursesGuard } from './guards/admin-courses-guard';
import { editProfileGuard } from './guards/edit-profile-guard';
import { coursesGuard } from './guards/courses-guard';

export const routes: Routes = [
    { path: '', component: Login },
     
  {
  path: 'admin',
  canMatch: [adminCoursesGuard],
loadComponent: () => import('./Pages/admin-courses/admin-courses').then(m => m.AdminCourses)

},
{
  path: 'edit-profile',
  component: EditProfile,
  canDeactivate: [editProfileGuard],canActivate:[coursesGuard]
},
{ path: 'courses', component: Courses , canActivate:[coursesGuard]},


];
