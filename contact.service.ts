import { Injectable } from '@angular/core';
import { Contact } from '../models/contact';


@Injectable({
  providedIn: 'root'
})
export class ContactService {
  
  contacts:Contact[];

  constructor() { 
    this.contacts=[
       {contactID:101,firstName:"Suchi",lastName:"Tanguturu",dob:new Date("1998-06-05"),mobileNumber:"9441027798",mailId:"suchi12@gmail.com",organization:"cts"},
       {contactID:102,firstName:"Anji",lastName:"Tanguturu",dob:new Date("2001-05-17"),mobileNumber:"9445678679",mailId:"anji341@gmail.com",organization:"tcs"},
       {contactID:103,firstName:"Ramu",lastName:"Nandyala",dob:new Date("1985-06-05"),mobileNumber:"9491456783",mailId:"ramu1985@gmail.com",organization:"infosys"}

    ];
  }
  getAll():Contact[]{
    return this.contacts;
  }
  get(id:number){
    return this.contacts.find((c)=>(c.contactID==id));
  }
  add(contact:Contact){
    this.contacts.push(contact);
  }
  update(contact:Contact){
    let index= this.contacts.findIndex((contact)=>(contact.contactID));
    if(index>-1){
      this.contacts.splice(index,1);

    }

  }
  delete(id:number){
    let index= this.contacts.findIndex((contact)=>(contact.contactID===id));
    if(index>-1){
      this.contacts.splice(index,1);
    }
  }

  }

