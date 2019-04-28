import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { RestApiService } from "../shared/rest-api.service";

@Component({
selector: 'app-convert-mass',
templateUrl: './convert-mass.component.html',
styleUrls: ['./convert-mass.component.css']
})
export class ConvertMassComponent implements OnInit {

@Input() convertDetails = { value: '', fromUnit: '', toUnit: '' }

constructor(
    public restApi: RestApiService,
    public router: Router
  ) { }

  ngOnInit() { }

  convertMass(data) {
    this.restApi.convertMass(this.convertDetails.value, this.convertDetails.fromUnit, this.convertDetails.toUnit).subscribe((data: {}) => {
      this.router.navigate(['/index'])
    })
  }

}
