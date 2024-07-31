import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-login-register-button',
  standalone: true,
  imports: [],
  templateUrl: './login-register-button.component.html',
  styleUrl: './login-register-button.component.css'
})
export class LoginRegisterButtonComponent {
  @Input() btnText: string = '';
}
