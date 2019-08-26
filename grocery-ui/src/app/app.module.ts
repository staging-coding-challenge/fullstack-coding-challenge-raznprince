import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListFormComponent } from './list-form/list-form.component';
import { GroceryListsComponent } from './grocery-lists/grocery-lists.component';

@NgModule({
  declarations: [
    AppComponent,
    ListFormComponent,
    GroceryListsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
