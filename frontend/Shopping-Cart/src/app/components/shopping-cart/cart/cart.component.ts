import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { CartItem } from 'src/app/models/cart-item';
import { Items } from 'src/app/models/cart-item'
import { Product } from 'src/app/models/product';
import { CartService } from 'src/app/services/cart.service';
import { LoginService } from 'src/app/services/login.service';
import { ProductService } from 'src/app/services/product.service';
import { UserprofileService } from 'src/app/services/userprofile.service';
import { CheckoutComponent } from '../../checkout/checkout.component';
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
  public cid : number
  public loggedIn = false;
  public len = 0;
  public cost : string;

  constructor(
    private cartService: CartService,
    private route: ActivatedRoute,
    private productService : ProductService,
    private loginservice : LoginService,
    private router:Router,
    private dialog : MatDialog
    
  ) { }

  ngOnInit() {
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

  public checkout(Cart){
    this.dialog.open(CheckoutComponent,{
      data:{'Cart':Cart}
    });
  }

  getCart(){
    this.cartService.getCart().subscribe(
      (response:CartItem)=>{
        this.Cart = response;
        this.cid = response.cartId;
        this.cartItems = response.items;
        this.len=response.items.length;
        this.costs(this.Cart.totalPrice);
        console.log(response);
        
      },error=>{
        this.router.navigate(['error'])
          }
    );

  }

  updateCart(id:number)
  {
    this.cartService.updateCart(this.cid,id).subscribe(
      (response:any)=>
      {
        if(this.Cart.items.length==0){
          location.reload();
        }else{
          this.ngOnInit();
        }
        
      },error=>{
        console.log(error);
        }
    );

  }
  costs(price:number){
    var x:string=price.toString();
    var lastThree = x.substring(x.length-3);
    var otherNumbers = x.substring(0,x.length-3);
    if(otherNumbers != '')
        lastThree = ',' + lastThree;
    var res = otherNumbers.replace(/\B(?=(\d{2})+(?!\d))/g, ",") + lastThree;
    this.cost = res;
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

