import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, NgForm } from '@angular/forms'
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/models/userprofile';
import { UserprofileService } from 'src/app/services/userprofile.service';
/**
 *
 * @param form
 */

function passwordsMatchValidator(form) {
  const password = form.get('password')
  const confirmPassword = form.get('confirmPassword')

  if(password.value !== confirmPassword.value) {
    confirmPassword.setErrors({ passwordsMatch: true })
  } else {
    confirmPassword.setErrors(null)
  }

  return null
}

/**
 * If the data is valid return null else return an object
 */
function symbolValidator(control) { //control = registerForm.get('password')
  if(control.hasError('required')) return null;
  if(control.hasError('minlength')) return null;

  if(control.value.indexOf('@') > -1) {
    return null
  } else {
    return { symbol: true }
  }
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public name : string;
  

  constructor() { }

  ngOnInit() {
   
  }

  
}
