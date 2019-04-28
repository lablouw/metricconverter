import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { map, tap, retry, catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestApiService {

apiURL = 'http://localhost:8090';

constructor(private http: HttpClient) {
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type':  'application/json'
        })
      };
  }

  private extractData(res: Response) {
    let body = res;
    return body || { };
  }

  getAvailableMassUnits(): Observable<any> {
    return this.http.get(this.apiURL + '/availableMassUnits').pipe(
    map(this.extractData));
  }

  getAvailableDistanceUnits(): Observable<any> {
    return this.http.get(this.apiURL + '/availableDistanceUnits').pipe(
    map(this.extractData));
  }

  getAvailableTemperatureUnits(): Observable<any> {
    return this.http.get(this.apiURL + '/availableTemperatureUnits').pipe(
    map(this.extractData));
  }

  convertTemperature(value, fromUnit, toUnit): Observable<any> {
    return this.http.get(this.apiURL + '/convertTemperature?value='+value+'&fromUnit='+fromUnit+'&toUnit='+toUnit)
    .pipe(
      retry(1)
    )
  }

  convertMass(value, fromUnit, toUnit): Observable<any> {
    return this.http.get(this.apiURL + '/convertMass?value='+value+'&fromUnit='+fromUnit+'&toUnit='+toUnit)
    .pipe(
      retry(1)
    )
  }

  convertDistance(value, fromUnit, toUnit): Observable<any> {
    return this.http.get(this.apiURL + '/convertDistance?value='+value+'&fromUnit='+fromUnit+'&toUnit='+toUnit)
    .pipe(
      retry(1)
    )
  }

}
