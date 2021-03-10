import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoriausuarioComponent } from './historiausuario.component';

describe('HistoriausuarioComponent', () => {
  let component: HistoriausuarioComponent;
  let fixture: ComponentFixture<HistoriausuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistoriausuarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HistoriausuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
