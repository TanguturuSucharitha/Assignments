import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-observable-demo',
  templateUrl: './observable-demo.component.html',
  styleUrls: ['./observable-demo.component.css']
})
export class ObservableDemoComponent implements OnInit {

  //image: string;
  lb:number;
  ub:number;
  isJobDone:boolean;

  result : number[];
  errMsg : string;

  constructor(private numService:NumberSeriesService) {
    this.lb=0;
    this.ub=0;
    this.isJobDone=true;

    let ob=this.numService.generateSeries(this.lb,this.ub);

    ob.subscribe{
      (num) => {this.result.push(num); }
      (errMsg) => {this.errMsg=errMsg; this.isJobDone=true;},
      ()=>{this.isJobDone=true;}
    });
    
   }

  ngOnInit() {
  }

}
