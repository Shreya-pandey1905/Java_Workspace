import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../Service/auth-service';

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
    this.router.navigate(['/dashboard']);
  }
}


