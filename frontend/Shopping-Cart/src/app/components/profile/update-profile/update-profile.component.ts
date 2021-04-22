import { Component, OnInit } from '@angular/core';
import { render } from 'creditcardpayments/creditCardPayments'
import { LoginService } from 'src/app/services/login.service';
import { OrdersService } from 'src/app/services/orders.service';
@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {
  
 

  constructor(private order : OrdersService
    
  // ) { 
  //   render(
  //     {
  //       id: "#myPaypalButtons",
  //       currency:"INR",
  //       value:"100.00",
  //       onApprove:(details)=> {
  //         alert("Transaction Successfull");
  //       }
  //     }
  //   );
  // }
  ){}

  ngOnInit() {
  }

 

}
