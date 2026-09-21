import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TraditionalReactiveForms } from './Pages/traditional-reactive-forms/traditional-reactive-forms';
import { Formwithsignal } from './Pages/form-with-signal/form-with-signal';

@Component({
  imports: [RouterOutlet, TraditionalReactiveForms, Formwithsignal],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('AngularForms');
}
