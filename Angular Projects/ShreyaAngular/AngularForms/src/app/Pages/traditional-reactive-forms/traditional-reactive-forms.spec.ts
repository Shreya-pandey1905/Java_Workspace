import { ComponentFixture, TestBed } from '@angular/core/testing';
import { TraditionalReactiveForms } from './traditional-reactive-forms';

describe('TraditionalReactiveForms', () => {
  let component: TraditionalReactiveForms;
  let fixture: ComponentFixture<TraditionalReactiveForms>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TraditionalReactiveForms],
    }).compileComponents();

    fixture = TestBed.createComponent(TraditionalReactiveForms);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
