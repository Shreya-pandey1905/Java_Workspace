import { Component, inject } from '@angular/core';
import { AuthService } from '../../Service/auth-service';
import { Router } from '@angular/router';

@Component({
  imports: [],
  selector: 'app-login',
  styleUrl: './login.css',
  templateUrl: './login.html',
})
export class Login {

   authservice= inject(AuthService);
  router= inject(Router);

  login(){
    this.authservice.login();
    this.router.navigate(['/courses']);
  }

  loginAsAdmin(){
    this.authservice.loginAsAdmin();
    this.router.navigate(['/admin']);
  }

}
