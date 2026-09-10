import { Component } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-product',
  styleUrl: './product.css',
  templateUrl: './product.html',
})
export class Product {
  products = signal<Product[]>([
    {
      id: 1,
      name: 'samsung',
      price: 80000,
    },
    {
      id: 2,
      name: 'Macbook',
      price: 200000,
    }
  ]);

  selectedProducts = signal<Product[]>([]);

  receiveProduct(product:Product){
    this.selectedProducts.update(list=>[
      ...list,
      product
    ]);
  }
}
