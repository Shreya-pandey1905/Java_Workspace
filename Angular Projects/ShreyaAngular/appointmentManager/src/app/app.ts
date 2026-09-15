
import { Component, model, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { Appointment } from '../../model/Appointment';
@Component({
  imports: [RouterOutlet],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App implements OnInit {
  
  newAppointmentTitle = signal('');
  newAppointmentDate = signal('');

  appointments = signal<Appointment[]>([]);

  ngOnInit(): void {
    console.log('Component Loaded');

    const saveAppointments= localStorage.getItem('appointments');
    if(saveAppointments){
      this.appointments.set(
        JSON.parse(saveAppointments)
      );
    }
  }

  addAppointment() {
    if (
      this.newAppointmentTitle().trim() &&
      this.newAppointmentDate()
    ) {
      const newAppointment: Appointment = {
        id: Date.now(),
        title: this.newAppointmentTitle(),
        date: this.newAppointmentDate()
      };

      this.appointments.update(currentAppointments => [
        ...currentAppointments,
        newAppointment
      ]);

      this.saveAppointments();
      this.newAppointmentTitle.set('');
      this.newAppointmentDate.set('');
    }
  }

  deleteAppointment(id:number){
    this.appointments.update(currentAppointments=>
      currentAppointments.filter(
        appointment=> appointment.id!==id
      )
    );
    this.saveAppointments();

  }

  saveAppointments() {
    localStorage.setItem(
      'appointments',
      JSON.stringify(this.appointments())
    );
  }
}

