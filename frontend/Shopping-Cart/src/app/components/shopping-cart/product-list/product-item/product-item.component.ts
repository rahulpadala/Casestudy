import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/models/product';
import { User } from 'src/app/models/userprofile';
import { CartService } from 'src/app/services/cart.service';
import { LoginService } from 'src/app/services/login.service';
import { ProductService } from 'src/app/services/product.service';
import { UserprofileService } from 'src/app/services/userprofile.service';

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {

  public product: Product;
  public id : number;
  public loggedIn = false;
  public Cid : number ; 

  constructor(private productService : ProductService,private route: ActivatedRoute,private loginservice : LoginService,
    private cartService : CartService,private userService: UserprofileService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.getProductById(this.id);
    this.loggedIn = this.loginservice.isLoggedIn();
    this.getUser();
  }

  public getProductById(id: number): void {
    this.productService.getProductByID(id).subscribe(
      (response: Product) => {
        this.product = response;
        console.log(this.product);
        this.costs(this.product.price);
      },
      (error: HttpErrorResponse) => {
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
    this.product.cost = otherNumbers.replace(/\B(?=(\d{2})+(?!\d))/g, ",") + lastThree;
  }

  getUser()
  {
    if(this.loggedIn)
    {
    this.userService.getUser().subscribe(
      (response:User)=>{
        this.Cid=response.profileId;
      }
    )
    }
  }

  addToCart(id:number)
  {
    console.log("kk");
    this.cartService.addProductToCart(this.Cid,id).subscribe(
      (response) =>{
        console.log("added to cart");    
      },(error: HttpErrorResponse)=> {
        alert(error.message);
      }
    );
  }



}
