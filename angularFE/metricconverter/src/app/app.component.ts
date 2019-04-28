import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { RestApiService } from "./shared/rest-api.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Lloyd\'s Metric Converter';

  @Input() convertDetails = { value: '', fromUnit: '', toUnit: '' }

  constructor(
    public restApi: RestApiService,
    public router: Router
  ) { }

  ngOnInit() { }

  convertMass(value, fromUnit, toUnit) {
    this.restApi.convertMass(this.convertDetails.value, this.convertDetails.fromUnit, this.convertDetails.toUnit).subscribe((data: {}) => {
      this.router.navigate(['/index'])
    })
  }

  convertDistance(value, fromUnit, toUnit) {
    this.restApi.convertDistance(this.convertDetails.value, this.convertDetails.fromUnit, this.convertDetails.toUnit).subscribe((data: {}) => {
      this.router.navigate(['/index'])
    })
  }

  convertTemperature(value, fromUnit, toUnit) {
    this.restApi.convertTemperature(this.convertDetails.value, this.convertDetails.fromUnit, this.convertDetails.toUnit).subscribe((data: {}) => {
      this.router.navigate(['/index'])
    })
  }


}
