import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatDialog } from '@angular/material';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';
import { UpdateStockComponent } from './update-stock/update-stock.component';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

  public product : Product;
  public products: Product[] | undefined;
  public cost:String[];


  constructor(private productService: ProductService,private dialog : MatDialog) { }


  ngOnInit() {

    this.getProducts()

  }


  public addProduct(addForm: NgForm): void{
    // document.getElementById('add-employee-form').click();
    this.productService.addProduct(addForm.value).subscribe(
      (response: Product) => {
        console.log(response);
        addForm.reset();
        window.location.href="/shop";
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public deleteProduct(id:number){
    this.productService.deleteProduct(id).subscribe(
      (response)=>{
        location.reload();
      },
      (error: HttpErrorResponse)=> {
        alert(error.message);
      }
    )
  }

  public update(id:number){
    this.dialog.open(UpdateStockComponent , {data:{pid : id}});
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

  getcosts()
  {
    for (let index = 0; index < this.products.length; index++) {
      this.products[index].cost = this.costs(this.products[index].price);
    }
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
