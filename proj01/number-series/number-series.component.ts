import { Component, OnInit } from '@angular/core';
import {NumberSeriesService} from '../services/number-series.service';
import { generate } from 'rxjs';
@Component({
  selector: 'app-number-series',
  templateUrl: './number-series.component.html',
  styleUrls: ['./number-series.component.css']
})
export class NumberSeriesComponent implements {
  lb:number;
  ub:number;
  isJobDone:boolean;

  result : number[];
  errMsg : string;

  constructor(private numSerService:NumberSeriesService) {

    this.lb=0;
    this.ub=0;
    this.isJobDone=true;
  }
  generate()
  this.result=[];
  this.errMsg=null;
  this.isJobDone=false;

    let ob=this.numService.generateSeries(this.lb,this.ub);
    ob.subscribe(
      (num) => {this.result.push(num); },
      (errMsg) => {this.errMsg=errMsg; this.isJobDone=true;},
      ()=>{this.isJobDone=true;}
    );
  
   }
}
