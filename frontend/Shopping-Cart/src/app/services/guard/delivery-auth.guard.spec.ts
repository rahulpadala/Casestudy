import { TestBed, async, inject } from '@angular/core/testing';

import { DeliveryAuthGuard } from './delivery-auth.guard';

describe('DeliveryAuthGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DeliveryAuthGuard]
    });
  });

  it('should ...', inject([DeliveryAuthGuard], (guard: DeliveryAuthGuard) => {
    expect(guard).toBeTruthy();
  }));
});
