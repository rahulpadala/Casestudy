import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateStockComponent } from './update-stock.component';

describe('UpdateStockComponent', () => {
  let component: UpdateStockComponent;
  let fixture: ComponentFixture<UpdateStockComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateStockComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
