import { Component, OnInit } from '@angular/core';
import { TaskService } from '../services/task.service';
import { Task } from '../models/task';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  tasks : Task[];
  constructor(private taskServ:TaskService) { }


  ngOnInit() {
    this.tasks=this.taskServ.getAll();
  }
  delete(taskId:number){
    if(confirm(`Are you sure of deleting Task#${taskId}`)){
      this.taskServ.delete(taskId);
    }
  }

}
