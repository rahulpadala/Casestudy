import { Component, OnInit } from '@angular/core';

import { ProductService } from 'src/app/services/product.service'
import { Product } from 'src/app/models/product';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';



@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit{

  public products: Product[] | undefined;
  
  constructor( private productService : ProductService,private router:Router){}
  ngOnInit(): void {
    this.getProducts()
  }

  public getProducts(): void {
    this.productService.getProducts().subscribe(
      (response: Product[]) => {
        this.products = response;
      },
      (error: HttpErrorResponse)=> {
        alert(error.message);
      }

    );
  }

    getProductById(id:number){
      this.router.navigate(['product',id])
     }
  }

  

  

