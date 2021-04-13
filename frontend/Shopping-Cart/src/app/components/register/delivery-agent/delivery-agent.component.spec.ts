import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeliveryAgentComponent } from './delivery-agent.component';

describe('DeliveryAgentComponent', () => {
  let component: DeliveryAgentComponent;
  let fixture: ComponentFixture<DeliveryAgentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeliveryAgentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeliveryAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
