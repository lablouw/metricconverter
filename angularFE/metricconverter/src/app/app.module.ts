import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ConvertTemperatureComponent } from './convert-temperature/convert-temperature.component';
import { ConvertMassComponent } from './convert-mass/convert-mass.component';
import { ConvertDistanceComponent } from './convert-distance/convert-distance.component';

const routes: Routes = [
{ path: 'convert-temperature', component: ConvertTemperatureComponent },
{ path: 'employee-details/:id', component: ConvertDistanceComponent },
{ path: 'update-employee', component: ConvertMassComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    ConvertTemperatureComponent,
    ConvertMassComponent,
    ConvertDistanceComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
