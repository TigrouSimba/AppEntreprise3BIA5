import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StagePageComponent } from './stage-page.component';

describe('StagePageComponent', () => {
  let component: StagePageComponent;
  let fixture: ComponentFixture<StagePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StagePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StagePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
