import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConvertTemperatureComponent } from './convert-temperature.component';

describe('ConvertTemperatureComponent', () => {
  let component: ConvertTemperatureComponent;
  let fixture: ComponentFixture<ConvertTemperatureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConvertTemperatureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConvertTemperatureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
