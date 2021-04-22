import { Component, NgModule } from '@angular/core'
import { Routes, RouterModule } from '@angular/router'

import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component'
import { LoginComponent } from './components/login/login.component'
import { RegisterComponent } from './components/register/register.component'
import { PageNotFoundComponent } from './components/shared/page-not-found/page-not-found.component'
import { CartComponent } from './components/shopping-cart/cart/cart.component'
import { ProductItemComponent } from './components/shopping-cart/product-list/product-item/product-item.component'
import { AuthGuard } from './services/guard/auth.guard'
import { StockComponent } from './components/stock/stock.component'
import { CheckoutComponent } from './components/checkout/checkout.component'
import { YourOrdersComponent } from './components/your-orders/your-orders.component'
import { ProfileComponent } from './components/profile/profile.component'
import { DeliveryComponent } from './components/delivery/delivery.component'
import { CustomerAuthGuard } from './services/guard/customer-auth.guard'
import { UnauthorizedComponent } from './components/shared/unauthorized/unauthorized.component'
import { DeliveryAuthGuard } from './services/guard/delivery-auth.guard'
import { MerchantAuthGuard } from './services/guard/merchant-auth.guard'
import { UpdateProfileComponent } from './components/profile/update-profile/update-profile.component'

const routes: Routes = [
  { path: '', redirectTo: '/shop', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register/:name',component:RegisterComponent },
  { path: 'shop', component: ShoppingCartComponent },
  { path : 'unauthorized', component:UnauthorizedComponent},
  { path: 'cart', component: CartComponent,canActivate:[AuthGuard,CustomerAuthGuard]},
  {path: 'product/:id', component:ProductItemComponent},
  {path: 'stock', component:StockComponent ,canActivate:[AuthGuard,MerchantAuthGuard]},
  { path: 'checkout',component:CheckoutComponent },
  { path: 'orders',component:YourOrdersComponent ,canActivate:[AuthGuard]},
  { path: 'profile',component:ProfileComponent ,canActivate:[AuthGuard] },
  { path: 'delivery',component:DeliveryComponent ,canActivate:[AuthGuard,DeliveryAuthGuard] },
  { path: 'updateProfile',component:UpdateProfileComponent },
  { path: '**', component: PageNotFoundComponent }
]

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
