import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module'
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/shared/header/header.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { NavComponent } from './components/shared/nav/nav.component';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';
import { ProductListComponent } from './components/shopping-cart/product-list/product-list.component';
import { CartComponent } from './components/shopping-cart/cart/cart.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { PageNotFoundComponent } from './components/shared/page-not-found/page-not-found.component';
import { CustomerComponent } from './components/register/customer/customer.component';
import { MerchantComponent } from './components/register/merchant/merchant.component';
import { DeliveryAgentComponent } from './components/register/delivery-agent/delivery-agent.component';
import { ProductItemComponent } from './components/shopping-cart/product-list/product-item/product-item.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
//import { AuthInterceptor } from './services/auth.interceptor';
import { LoginService } from './services/login.service';
//import { AddHeaderInterceptor, TokenInterceptor } from './services/token.interceptor.service';
import { TokenInterceptorService } from './services/token-interceptor.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSelectModule} from '@angular/material/select';
import {MatToolbarModule} from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import { StockComponent } from './components/stock/stock.component';
import { UpdateStockComponent } from './components/stock/update-stock/update-stock.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { OrdersComponent } from './components/orders/orders.component';
import {MatExpansionModule} from '@angular/material/expansion';
import { YourOrdersComponent } from './components/your-orders/your-orders.component';
import { ProfileComponent } from './components/profile/profile.component';
import { DeliveryComponent } from './components/delivery/delivery.component'

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    ShoppingCartComponent,
    ProductListComponent,
    CartComponent,
    LoginComponent,
    RegisterComponent,
    PageNotFoundComponent,
    CustomerComponent,
    MerchantComponent,
    DeliveryAgentComponent,
    ProductItemComponent,
    StockComponent,
    UpdateStockComponent,
    CheckoutComponent,
    OrdersComponent,
    YourOrdersComponent,
    ProfileComponent,
    DeliveryComponent
  ],
  entryComponents:[UpdateStockComponent,OrdersComponent,CheckoutComponent],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    BrowserAnimationsModule,
    MatSelectModule,
    MatToolbarModule,
    MatButtonModule,
    MatDialogModule,
    MatSidenavModule,
    MatExpansionModule,

  ],
  providers: [[{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptorService,
    multi: true
  }]],
  bootstrap: [AppComponent]
})
export class AppModule { }
