import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CambioestadoComponent } from './cambioestado.component';

describe('CambioestadoComponent', () => {
  let component: CambioestadoComponent;
  let fixture: ComponentFixture<CambioestadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CambioestadoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CambioestadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
