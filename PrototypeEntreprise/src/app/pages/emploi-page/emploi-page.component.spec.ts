import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmploiPageComponent } from './emploi-page.component';

describe('EmploiPageComponent', () => {
  let component: EmploiPageComponent;
  let fixture: ComponentFixture<EmploiPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmploiPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmploiPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
