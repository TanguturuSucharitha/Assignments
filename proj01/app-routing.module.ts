import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DashBoardComponent} from './dash-board/dash-board.component';
import {ObservableDemoComponent} from'./observable-demo/observable-demo.component';
import {PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [];
 {path:"",component:DashBoardComponent},
 {path:"obd"  }
 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
