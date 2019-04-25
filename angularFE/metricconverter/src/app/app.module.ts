import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';

const appRoutes: Routes = [
  {
    path: 'getAvailableTemperatureUnits',
    data: { title: 'Available Temperature Units' }
  },
  {
    path: 'convertTemperature',
    data: { title: 'Convert temperature' }
  }
]
@NgModule({
  declarations: [
    AppComponent,
    TemperatureUnitComponent,
    MassUnitComponent,
    DistanceUnitComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    FormsModule,
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
