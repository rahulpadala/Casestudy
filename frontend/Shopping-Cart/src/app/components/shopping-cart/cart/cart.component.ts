import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { CartService } from 'src/app/services/cart.service';
import { UserprofileService } from 'src/app/services/userprofile.service';
// import { CartItem } from 'src/app/models/cart-item';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent{

  cartItems = [];

  cartTotal = 0

  constructor(
    private cartService: CartService,
    private user:UserprofileService
  ) { }

  // ngOnInit() {
  //   this.loadCartItems();
  // }


  // loadCartItems() {
  //   this.cartService.getCartItems().subscribe((items: CartItem[]) => {
  //     this.cartItems = items;
  //     this.calcCartTotal();
  //   })
  // }

  calcCartTotal() {
    this.cartTotal = 0
    this.cartItems.forEach(item => {
      this.cartTotal += (item.qty * item.price)
    })
  }

  getUser()
  {
    this.user.getUser().subscribe(
      (response:any)=>{
      console.log(response);
      },
      error=>{
        console.log(error);
        
      }
    )

  }
}
