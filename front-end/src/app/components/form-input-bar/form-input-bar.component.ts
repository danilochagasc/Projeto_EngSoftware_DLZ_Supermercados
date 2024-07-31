import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-form-input-bar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './form-input-bar.component.html',
  styleUrl: './form-input-bar.component.css'
})
export class FormInputBarComponent {

  @Input() placeholder: string = '';
  @Input() type: string = 'text';
  placeholderChars: string[] = [];

  ngOnInit() {
    this.placeholderChars = this.placeholder.split('');
  }

}
