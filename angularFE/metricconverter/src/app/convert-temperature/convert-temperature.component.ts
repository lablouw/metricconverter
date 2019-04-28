import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { RestApiService } from "../shared/rest-api.service";

@Component({
selector: 'app-convert-temperature',
templateUrl: './convert-temperature.component.html',
styleUrls: ['./convert-temperature.component.css']
})
export class ConvertTemperatureComponent implements OnInit {

@Input() convertDetails = { temp: '', fromUnit: '', toUnit: '' }

constructor(
    public restApi: RestApiService,
    public router: Router
  ) { }

  ngOnInit() { }

  convertTemperature(data) {
    this.restApi.convertTemperature(this.convertDetails.temp, this.convertDetails.fromUnit, this.convertDetails.toUnit).subscribe((data: {}) => {
      this.router.navigate(['/'])
    })
  }

}
