import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { map, tap, catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestApiService {

apiURL = 'http://localhost:8080';

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

  convertTemperature(temperature, fromUnit, toUnit): Observable<any> {
    return this.http.get(this.apiURL + '/convertTemperature?temperature='+temperature+'&fromUnit='+fromUnit+'&toUnit='+toUnit).pipe(
    map(this.extractData));
  }

  convertMass(mass, fromUnit, toUnit): Observable<any> {
    return this.http.get(this.apiURL + '/convertTemperature?mass='+mass+'&fromUnit='+fromUnit+'&toUnit='+toUnit).pipe(
    map(this.extractData));
  }

  convertDistance(distance, fromUnit, toUnit): Observable<any> {
    return this.http.get(this.apiURL + '/convertDistance?mass='+distance+'&fromUnit='+fromUnit+'&toUnit='+toUnit).pipe(
    map(this.extractData));
  }

}
