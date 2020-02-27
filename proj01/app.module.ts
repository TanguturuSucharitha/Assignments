import {BrowserModule } from '@angular/platform-browser';                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ObservableDemoComponent } from './observable-demo/observable-demo.component';
import { DashBoardComponent } from './dash-board/dash-board.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { NumberSeriesComponent } from './number-series/number-series.component';
import {FormsModule} from '@angular/forms';
import { NavBarComponent } from './nav-bar/nav-bar.component'

@NgModule({
  declarations: [
    AppComponent,
    ObservableDemoComponent,
    DashBoardComponent,
    FooterComponent,
    HeaderComponent,
    PageNotFoundComponent,
    NumberSeriesComponent,
    NavBarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
