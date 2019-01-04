import { Component } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from "../environments/environment";

@Component({
    selector: 'app-root', template: `
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <form class="form-horizontal" (ngSubmit)="onSubmit()">
                        <h1>Currency Conversion</h1>
                        <div class="form-group">
                            <label for="conversionType" class="col-sm-2 control-label">Conversion type</label>
                            <div class="col-sm-10">
                                <select id="conversionType" name="conversionType" class="form-control" [(ngModel)]="selectedConversionType">
                                    <option *ngFor="let ct of conversionTypes" [ngValue]="ct">{{ct.from}}
                                        -> {{ct.to}}</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="amount" class="col-sm-2 control-label">Amount</label>
                            <div class="col-sm-10">
                                <input id="amount" name="amount" type="number" class="form-control" [(ngModel)]="amount">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2">Calculated Amount:</div>
                <div class="col-sm-10">{{conversionServiceResponse?.totalCalculatedAmount}}</div>
            </div>
            <div class="row">
                <div class="col-sm-2">Converter Service Port:</div>
                <div class="col-sm-10">{{conversionServiceResponse?.converterPort}}</div>
            </div>
            <div class="row">
                <div class="col-sm-2">Forex Service Port:</div>
                <div class="col-sm-10">{{conversionServiceResponse?.forexPort}}</div>
            </div>
        </div>
    `
})
export class AppComponent {
    public conversionTypes: Array<ConversionType> = [
        {
            from: 'USD', to: 'INR'
        }, {
            from: 'EUR', to: 'INR'
        }, {
            from: 'AUD', to: 'INR'
        }
    ];
    public selectedConversionType: ConversionType;
    public amount: string;
    public conversionServiceResponse: ConversionServiceResponse;

    constructor (private http: HttpClient) {
    }

    public onSubmit () {
        this.convertCurrency(this.selectedConversionType.from, this.selectedConversionType.to, this.amount);
    }

    private convertCurrency (fromCurrency: string, toCurrency: string, amount: string) {
        this.http.get(this.conversionServiceUrl(fromCurrency, toCurrency, amount)).subscribe((response: ConversionServiceResponse) => {
            this.conversionServiceResponse = response;
        });
    }

    private conversionServiceUrl (fromCurrency: string, toCurrency: string, amount: string) {
        return `${environment.zuulServerUrl}/convert-currency/from/${fromCurrency}/to/${toCurrency}/quantity/${amount}`;
    }
}

interface ConversionType {
    from: string;
    to: string;
}

interface ConversionServiceResponse {
    totalCalculatedAmount: number;
    forexPort: number;
    converterPort: number;
}
