import { Component, OnInit } from '@angular/core';
import { Task } from '../models/task';
import { TaskService } from '../services/task.service';
import { ActivatedRoute, Router } from '@angular/router';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent implements OnInit {

  private task:Task;
  private isNew:boolean;
  private dobStr:string;

  constructor(private taskServ:TaskService,
    private routeData:ActivatedRoute,
    private router:Router
    ) { }

  ngOnInit() {
    this.routeData.params.subscribe(
      (params)=>{
        let taskID = params['tid'];

        if(taskID==undefined){
          this.isNew=true;
          this.task=new Task();
          this.dobStr=(new Date()).toISOString().substr(0,10);
        }
      }

    );
  }


dobUpdate(){
this.task.startDate=new Date(this.dobStr);
this.task.endDate=new Date(this.dobStr);
}

save(){
  if(this.isNew){
    this.taskServ.add(this.task);
  }else{
    this.taskServ.update(this.task);
  }
  this.router.navigateByUrl("/list");
  }
}
