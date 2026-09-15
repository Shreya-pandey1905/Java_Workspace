import { signal } from '@angular/core';
import { CanDeactivateFn } from '@angular/router';
import { EditProfile } from '../Pages/edit-profile/edit-profile';

export const editProfileGuard: CanDeactivateFn<EditProfile> = (
  component) => {
    
  if(component.unsavedChanges()){
    return confirm('you have some unsaved changes !! still do you want to leave');
  }
  return true;

};
