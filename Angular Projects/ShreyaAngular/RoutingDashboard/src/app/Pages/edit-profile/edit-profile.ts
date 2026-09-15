import { Component, signal } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-edit-profile',
  styleUrl: './edit-profile.css',
  templateUrl: './edit-profile.html',
})
export class EditProfile {
  name= signal('');
  unsavedChanges= signal(false);

  updateName(val:string){
    this.name.set(val);
    this.unsavedChanges.set(true);
  }
  save(){
    alert("profile saved successfully");
    this.unsavedChanges.set(false);
      this.name.set('');
  }

  
}
