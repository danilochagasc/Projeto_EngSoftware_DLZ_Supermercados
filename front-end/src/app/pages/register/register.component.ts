import { Component } from '@angular/core';
import { FormInputBarComponent } from '../../components/form-input-bar/form-input-bar.component';
import { LoginRegisterButtonComponent } from '../../components/login-register-button/login-register-button.component';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormInputBarComponent, LoginRegisterButtonComponent],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

}
