import { Component } from '@angular/core';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import { heroShoppingCartSolid } from '@ng-icons/heroicons/solid';
import { heroUserCircleSolid } from '@ng-icons/heroicons/solid';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [NgIconComponent],
  providers: [provideIcons({ heroShoppingCartSolid, heroUserCircleSolid })],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

}
