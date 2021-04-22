import { TestBed, async, inject } from '@angular/core/testing';

import { MerchantAuthGuard } from './merchant-auth.guard';

describe('MerchantAuthGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MerchantAuthGuard]
    });
  });

  it('should ...', inject([MerchantAuthGuard], (guard: MerchantAuthGuard) => {
    expect(guard).toBeTruthy();
  }));
});
