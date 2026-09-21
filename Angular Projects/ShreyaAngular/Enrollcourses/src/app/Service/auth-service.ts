import { Service, signal } from '@angular/core';

@Service()
export class AuthService {
    isLoggedIn= signal(false);
    login(){
       this.isLoggedIn.set(true);
    }
     logout(){
       this.isLoggedIn.set(false);
       this.isAdmin.set(false);
    }

    isAdmin= signal(false);

    loginAsAdmin(){
     this.isLoggedIn.set(true);
     this.isAdmin.set(true);
    }
}
