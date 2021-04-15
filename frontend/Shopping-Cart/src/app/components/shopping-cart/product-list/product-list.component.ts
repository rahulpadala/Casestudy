import { Component, OnInit } from '@angular/core';

import { ProductService } from 'src/app/services/product.service'
import { Product } from 'src/app/models/product';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { UserprofileService } from 'src/app/services/userprofile.service';
import { User } from 'src/app/models/userprofile';
import { CartService } from 'src/app/services/cart.service';
import { LoginService } from 'src/app/services/login.service';
import { CartItem } from 'src/app/models/cart-item';



@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit{

  public products: Product[] | undefined;
  public cost:String[];
  public Cid:number;
  constructor( private productService : ProductService,private router:Router,private userService: UserprofileService,
    private cartService : CartService,private login : LoginService
    ){}
  ngOnInit(): void {
    this.getProducts();
    this.logeedIn();
  }

  public getProducts(): void {
    this.productService.getProducts().subscribe(
      (response: Product[]) => {
        this.products = response;
        console.log(response);     
        this.getcosts();
      },
      (error: HttpErrorResponse)=> {
        alert(error.message);
      }
    );
  }

  logeedIn()
  {
    if(this.login.isLoggedIn())
    {
      this.getUser();
    }
  }

  getcosts()
  {
    for (let index = 0; index < this.products.length; index++) {
      this.products[index].cost = this.costs(this.products[index].price);
    }
  }

  getUser()
  {
    this.userService.getUser().subscribe(
      (response:User)=>{
        this.Cid=response.profileId;
      }
    )
  }



  addToCart(Pid:number)
  {
    this.cartService.addProductToCart(this.Cid,Pid).subscribe(
      (response) =>{
      },(error: HttpErrorResponse)=> {
        alert(error.message);
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
    return res;
  }

}

  

  

