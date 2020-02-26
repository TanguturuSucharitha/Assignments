import { Injectable } from '@angular/core';
import {Task } from '../models/task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  tasks:Task[];


  constructor() {
    this.tasks=[
      {taskID:101,taskName:"Bootstrap",startDate:new Date("1998-06-05"),endDate:new Date("1998-06-25")},
      {taskID:102,taskName:"Css",startDate:new Date("1998-06-05"),endDate:new Date("1998-06-25")},
      {taskID:103,taskName:"Html",startDate:new Date("1998-06-05"),endDate:new Date("1998-06-25")}
    ];
   }
   getAll():Task[]{
    return this.tasks;
  }
  get(id:number){
    return this.tasks.find((t)=>(t.taskID==id));
  }
  add(task:Task){
    this.tasks.push(task);
  }
  update(task:Task){
    let index= this.tasks.findIndex((task)=>(task.taskID));
    if(index>-1){
      this.tasks.splice(index,1);

    }

  }
  delete(id:number){
    let index= this.tasks.findIndex((task)=>(task.taskID===id));
    if(index>-1){
      this.tasks.splice(index,1);
    }
  }

  }



