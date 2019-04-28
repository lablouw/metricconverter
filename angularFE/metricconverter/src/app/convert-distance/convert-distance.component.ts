import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { RestApiService } from "../shared/rest-api.service";

@Component({
selector: 'app-convert-distance',
templateUrl: './convert-distance.component.html',
styleUrls: ['./convert-distance.component.css']
})
export class ConvertDistanceComponent implements OnInit {

@Input() convertDetails = { temp: '', fromUnit: '', toUnit: '' }

constructor(
    public restApi: RestApiService,
    public router: Router
  ) { }

  ngOnInit() { }

  convertDistance(data) {
    this.restApi.convertDistance(this.convertDetails.temp, this.convertDetails.fromUnit, this.convertDetails.toUnit).subscribe((data: {}) => {
      this.router.navigate(['/'])
    })
  }

}
