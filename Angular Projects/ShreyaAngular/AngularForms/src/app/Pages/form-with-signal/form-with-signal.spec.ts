import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormWithSignal } from './form-with-signal';

describe('FormWithSignal', () => {
  let component: FormWithSignal;
  let fixture: ComponentFixture<FormWithSignal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormWithSignal],
    }).compileComponents();

    fixture = TestBed.createComponent(FormWithSignal);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
