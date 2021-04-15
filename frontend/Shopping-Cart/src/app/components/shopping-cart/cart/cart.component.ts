import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartItem } from 'src/app/models/cart-item';
import { Items } from 'src/app/models/cart-item'
import { Product } from 'src/app/models/product';
import { CartService } from 'src/app/services/cart.service';
import { LoginService } from 'src/app/services/login.service';
import { ProductService } from 'src/app/services/product.service';
import { UserprofileService } from 'src/app/services/userprofile.service';
// import { CartItem } from 'src/app/models/cart-item';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit{

  public cartItems : any;

  cartTotal = 0

  public Cart : CartItem
  public id : number
  public loggedIn = false;
  public len = 0;

  constructor(
    private cartService: CartService,
    private route: ActivatedRoute,
    private productService : ProductService,
    private loginservice : LoginService
    
  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.IsloggenIn();    
  }


  // loadCartItems() {
  //   this.cartService.getCartItems().subscribe((items: CartItem[]) => {
  //     this.cartItems = items;
  //     this.calcCartTotal();
  //   })
  // }

  // calcCartTotal() {
  //   this.cartTotal = 0
  //   this.cartItems.forEach(item => {
  //     this.cartTotal += (item.qty * item.price)
  //   })
  // }

  IsloggenIn(){
    if(this.loginservice.isLoggedIn()){
      this.loggedIn = true;
      this.getCart();
    }
  }

  getCart(){
    this.cartService.getCart().subscribe(
      (response:CartItem)=>{
        this.Cart = response;
        this.cartItems = response.items;
        this.len=response.items.length; 
        console.log(response);
        
      },error=>{
         console.log(error);
          }
    );

  }


  // items(){
  //   for (let index = 0; index < this.Cart.items.length ; index++) {
  //     this.cartItems.length;
  //   }
  // }



  // getUser()
  // {
  //   this.user.getUser().subscribe(
  //     (response:any)=>{
  //     console.log(response);
  //     },
  //     error=>{
  //       console.log(error);
        
  //     }
  //   )

 // }
}

