import { Component } from '@angular/core';
import { Product } from '../product/product';

@Component({
  imports: [],
  selector: 'app-cart',
  styleUrl: './cart.css',
  templateUrl: './cart.html',
})
export class Cart {
  product= input.required<Product>();


  productSelected= output<Product>();// it menas the child is capable of sending a product event to the parent
  selectProduct(){
    this.productSelected.emit(this.product()); // actually send the dat o6 the parent

  }
}
