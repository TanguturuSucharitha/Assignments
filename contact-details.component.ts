import { Component, OnInit } from '@angular/core';
import { Contact } from '../models/contact';
import { ContactService } from '../services/contact.service';
import { ActivatedRoute } from '@angular/router';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-contact-details',
  templateUrl: './contact-details.component.html',
  styleUrls: ['./contact-details.component.css']
})
export class ContactDetailsComponent implements OnInit {

  private contact: Contact;

  constructor(
    private contServ: ContactService,
    private routeData: ActivatedRoute
  ) { }

  ngOnInit() {
    this.routeData.params.subscribe(
      (params) => {
        let contactId = params['id'];
        if (contactId != undefined){
          this.contact = this.contServ.get(contactId);
        }

      }
    );
    
  }

}
