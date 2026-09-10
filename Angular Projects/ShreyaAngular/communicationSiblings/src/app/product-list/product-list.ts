import { Component, inject, signal } from '@angular/core';
import { CartService } from '../services/cart-service';
import { Product } from '../../model/product';
import { CommonModule } from '@angular/common';

@Component({
  imports: [CommonModule],
  selector: 'app-product-list',
  styleUrl: './product-list.css',
  templateUrl: './product-list.html',
})
export class ProductList {

  private cartService= inject(CartService);

  products= signal<Product[]>([
    {
      id:1,
      name: "Macbook Pro",
      price: 90000
    },
    {
       id:1,
      name: "Samsung",
      price: 7000
    }

  ]);


  addToCart(product:Product){
    this.cartService.addProduct(product);
  }


}
