import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleticketComponent } from './detalleticket.component';

describe('DetalleticketComponent', () => {
  let component: DetalleticketComponent;
  let fixture: ComponentFixture<DetalleticketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetalleticketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleticketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
