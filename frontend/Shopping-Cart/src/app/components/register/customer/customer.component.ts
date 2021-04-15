import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/userprofile';
import { UserprofileService } from 'src/app/services/userprofile.service';
import { NgForm } from '@angular/forms';
import { CartComponent } from '../../shopping-cart/cart/cart.component';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {


  public users: User[] | undefined;

  constructor(private userService: UserprofileService,private router: Router,private cart: CartService){}
  ngOnInit(){
    
  }

  public addNewCustomer(addForm: NgForm): void{
    // document.getElementById('add-employee-form').click();
    this.userService.addNewCustomer(addForm.value).subscribe(
      (response: User) => {
        console.log(response);
        addForm.reset();
        window.location.href="/login"
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }




}
