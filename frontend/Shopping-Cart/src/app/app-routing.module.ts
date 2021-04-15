import { Component, NgModule } from '@angular/core'
import { Routes, RouterModule } from '@angular/router'

import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component'
import { LoginComponent } from './components/login/login.component'
import { RegisterComponent } from './components/register/register.component'
import { PageNotFoundComponent } from './components/shared/page-not-found/page-not-found.component'
import { CustomerComponent } from './components/register/customer/customer.component'
import { MerchantComponent } from './components/register/merchant/merchant.component'
import { DeliveryAgentComponent } from './components/register/delivery-agent/delivery-agent.component'
import { CartComponent } from './components/shopping-cart/cart/cart.component'
import { ProductItemComponent } from './components/shopping-cart/product-list/product-item/product-item.component'
import { AuthGuard } from './services/auth.guard'

const routes: Routes = [
  { path: '', redirectTo: '/shop', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'customer',component:CustomerComponent},
  { path: 'merchant' , component:MerchantComponent},
  { path: 'deliveryAgent', component:DeliveryAgentComponent},
  { path: 'shop', component: ShoppingCartComponent },
  { path: 'cart', component: CartComponent,canActivate:[AuthGuard]},
  {path: 'product/:id', component:ProductItemComponent},
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
