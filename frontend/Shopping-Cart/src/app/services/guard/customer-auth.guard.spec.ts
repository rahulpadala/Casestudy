import { TestBed, async, inject } from '@angular/core/testing';

import { CustomerAuthGuard } from './customer-auth.guard';

describe('CustomerAuthGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CustomerAuthGuard]
    });
  });

  it('should ...', inject([CustomerAuthGuard], (guard: CustomerAuthGuard) => {
    expect(guard).toBeTruthy();
  }));
});
