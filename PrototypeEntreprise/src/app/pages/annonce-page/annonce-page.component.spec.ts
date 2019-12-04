import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnoncePageComponent } from './annonce-page.component';

describe('AnnoncePageComponent', () => {
  let component: AnnoncePageComponent;
  let fixture: ComponentFixture<AnnoncePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnnoncePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnnoncePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
