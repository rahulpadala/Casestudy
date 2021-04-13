import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/userprofile';
import { UserprofileService } from 'src/app/services/userprofile.service';

@Component({
  selector: 'app-merchant',
  templateUrl: './merchant.component.html',
  styleUrls: ['./merchant.component.css']
})
export class MerchantComponent implements OnInit {

  public users: User[] | undefined;

  constructor(private userService: UserprofileService,private router: Router){}
  ngOnInit(){
    //this.getUser();
  }

  // public getUser(): void {
  //   this.userService.getUsers().subscribe(
  //     (response: User[]) => {
  //       this.users = response;
  //     },
  //     (error: HttpErrorResponse)=> {
  //       alert(error.message);
  //     }

  //   );
  // }

  public addNewMerchant(addForm: NgForm): void{
    // document.getElementById('add-employee-form').click();
    this.userService.addNewMerchant(addForm.value).subscribe(
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
