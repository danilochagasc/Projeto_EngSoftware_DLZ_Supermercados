import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormInputBarComponent } from './form-input-bar.component';

describe('FormInputBarComponent', () => {
  let component: FormInputBarComponent;
  let fixture: ComponentFixture<FormInputBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormInputBarComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormInputBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
