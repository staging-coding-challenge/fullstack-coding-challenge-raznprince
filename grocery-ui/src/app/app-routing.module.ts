import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListFormComponent } from './list-form/list-form.component';
import { GroceryListsComponent } from './grocery-lists/grocery-lists.component';

const routes: Routes = [
  { path: 'grocery-lists', component: GroceryListsComponent },
  { path: 'list-form', component: ListFormComponent },
  { path: '', redirectTo: 'list-form', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
