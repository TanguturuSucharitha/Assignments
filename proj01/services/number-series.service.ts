import { Injectable } from '@angular/core';
import { Observable, observable, Observer } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NumberSeriesService {

  constructor() {}
    generateSeries(lb:number,ub:number) : Observable<number> {
      let ob=new Observable<number>((obr:Observer<number>)=> {
    if(lb>ub){
      obr.error("Invalid bounds");
      return;

    }
    let n=lb;

    let handler=setInterval(()=>{
    obr.next(n);
    n++;
    if(n>ub){
      clearInterval(handler);
      obr.complete();
    }
    },1000);
  });
  return ob;
}
}