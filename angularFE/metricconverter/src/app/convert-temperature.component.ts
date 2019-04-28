import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { RestService } from "../shared/rest-api.service";

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class ConvertTemperatureComponent implements OnInit {

  @Input() convertTemperatureDetails = { fromUnit: '', toUnit: '' }

  constructor(
    public restApi: RestService,
    public router: Router
  ) { }

  ngOnInit() { }

  convertTemperature(fromUnit, toUnit) {
    this.restApi.convertTemperate(this.convertTemperatureDetails).subscribe((data: {}) => {
      this.router.navigate(['/convertTemperature'])
    })
  }

}
