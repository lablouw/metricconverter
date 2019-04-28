import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConvertMassComponent } from './convert-mass.component';

describe('ConvertMassComponent', () => {
  let component: ConvertMassComponent;
  let fixture: ComponentFixture<ConvertMassComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConvertMassComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConvertMassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
