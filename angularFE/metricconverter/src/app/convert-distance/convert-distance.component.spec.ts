import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConvertDistanceComponent } from './convert-distance.component';

describe('ConvertDistanceComponent', () => {
  let component: ConvertDistanceComponent;
  let fixture: ComponentFixture<ConvertDistanceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConvertDistanceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConvertDistanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
