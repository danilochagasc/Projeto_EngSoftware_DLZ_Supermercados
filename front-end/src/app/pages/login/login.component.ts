import { Component } from '@angular/core';
import { FormInputBarComponent } from '../../components/form-input-bar/form-input-bar.component';
import { LoginRegisterButtonComponent } from "../../components/login-register-button/login-register-button.component";
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormInputBarComponent, LoginRegisterButtonComponent, RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

}
