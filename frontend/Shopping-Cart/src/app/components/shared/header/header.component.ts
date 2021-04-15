import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/userprofile';
import { LoginService } from 'src/app/services/login.service';
import { UserprofileService } from 'src/app/services/userprofile.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public name:string;
  constructor(private loginService : LoginService,private userservice : UserprofileService) {  }

  ngOnInit() {
    this.user()
  }

  user()
  {
    if(this.loginService.isLoggedIn())
    {
      this.userservice.getUser().subscribe(
        (response:User)=>
        {
          this.name = response.fullName;
        }
      )
    }
  }

}
