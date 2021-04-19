import { HttpErrorResponse } from '@angular/common/http';
import { Inject } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MatDialogModule, MAT_DIALOG_DATA } from '@angular/material';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-update-stock',
  templateUrl: './update-stock.component.html',
  styleUrls: ['./update-stock.component.css']
})
export class UpdateStockComponent implements OnInit {

  public editProduct : Product;
  constructor(@Inject(MAT_DIALOG_DATA) public data : any,private productService : ProductService) { }

  ngOnInit() {
    this.getProduct(this.data.pid)
  }

  public getProduct(id:number){
    this.productService.getProductByID(id).subscribe(
      (response:Product)=>{
        console.log(response);
        this.editProduct = response; 
      }
      );
  }

  public updateProduct(product : Product){
    // document.getElementById('add-employee-form').click();
    this.productService.updateProduct(product).subscribe(
      (response: Product) => {
        console.log(response);
        window.location.href="/stock"
        
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }



}
