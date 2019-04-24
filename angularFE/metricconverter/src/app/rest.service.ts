import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private http: HttpClient) {
    const endpoint = 'http://localhost:8080/';
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
    return this.http.get('http://localhost:8080/availableMassUnits').pipe(
    map(this.extractData));
  }

  getAvailableDistanceUnits(): Observable<any> {
    return this.http.get('http://localhost:8080/availableDistanceUnits').pipe(
    map(this.extractData));
  }

  getAvailableTemperatureUnits(): Observable<any> {
    return this.http.get('http://localhost:8080/availableTemperatureUnits').pipe(
    map(this.extractData));
  }

  convertTemperature(temperature, fromUnit, toUnit): Observable<any> {
    return this.http.get('http://localhost:8080/convertTemperature?temperature='+temperature+'&fromUnit='+fromUnit+'&toUnit='+toUnit).pipe(
    map(this.extractData));
  }

  convertMass(mass, fromUnit, toUnit): Observable<any> {
    return this.http.get('http://localhost:8080/convertTemperature?mass='+mass+'&fromUnit='+fromUnit+'&toUnit='+toUnit).pipe(
    map(this.extractData));
  }

  convertDistance(distance, fromUnit, toUnit): Observable<any> {
    return this.http.get('http://localhost:8080/convertDistance?mass='+distance+'&fromUnit='+fromUnit+'&toUnit='+toUnit).pipe(
    map(this.extractData));
  }


}
