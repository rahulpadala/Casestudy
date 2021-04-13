import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/userprofile';
import { UserprofileService } from 'src/app/services/userprofile.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-delivery-agent',
  templateUrl: './delivery-agent.component.html',
  styleUrls: ['./delivery-agent.component.css']
})
export class DeliveryAgentComponent implements OnInit {

  public users: User[] | undefined;

  constructor(private userService: UserprofileService,private router: Router){}
  ngOnInit(){
    
  }

  public addNewDeliveryAgent(addForm: NgForm): void{
    // document.getElementById('add-employee-form').click();
    this.userService.addNewDeliveryAgent(addForm.value).subscribe(
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
