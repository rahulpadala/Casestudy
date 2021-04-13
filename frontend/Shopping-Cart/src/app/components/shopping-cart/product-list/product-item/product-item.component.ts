import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {

  public product: Product;
  public id : number;

  constructor(private productService : ProductService,private route: ActivatedRoute) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.getProductById(this.id);
  }

  public getProductById(id: number): void {
    this.productService.getProductByID(id).subscribe(
      (response: Product) => {
        this.product = response;
        console.log(this.product);
        
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  images = [1, 2, 3].map(() => `https://picsum.photos/900/500?random&t=${Math.random()}`);

}
