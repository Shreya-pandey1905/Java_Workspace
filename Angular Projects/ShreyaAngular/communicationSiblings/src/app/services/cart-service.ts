import { computed, Service, signal } from '@angular/core';
import { Product } from '../../model/product';

@Service()
export class CartService {

    cartItems = signal<Product[]>([]);

    addProduct(product: Product){
        this.cartItems.update(items => [...items, product]);

    }

    removeProduct(index:number){
        this.cartItems.update(items => items.filter((_,i)=> i! == index));
    }

    cartCount = computed(()=> 
    this.cartItems().length);

    totalPrice = computed(()=>
    this.cartItems().reduce((total, item)=> total+ item.price,0)
     );


}

