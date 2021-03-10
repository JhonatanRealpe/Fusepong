import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarticketComponent } from './agregarticket.component';

describe('AgregarticketComponent', () => {
  let component: AgregarticketComponent;
  let fixture: ComponentFixture<AgregarticketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgregarticketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AgregarticketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
