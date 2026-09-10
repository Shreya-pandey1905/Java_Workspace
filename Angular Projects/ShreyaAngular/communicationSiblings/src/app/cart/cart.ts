import { Component, inject } from '@angular/core';
import { CartService } from '../services/cart-service';
import { CommonModule } from '@angular/common';

@Component({
  imports: [CommonModule],
  selector: 'app-cart',
  styleUrl: './cart.css',
  templateUrl: './cart.html',
})
export class Cart {
  cartService= inject(CartService);
}
