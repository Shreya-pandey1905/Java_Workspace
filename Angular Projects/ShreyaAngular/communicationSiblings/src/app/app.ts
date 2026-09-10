import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Cart } from "./cart/cart";
import { ProductList } from './product-list/product-list';

@Component({
  imports: [RouterOutlet, Cart,ProductList],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('communicationSiblings');
}
