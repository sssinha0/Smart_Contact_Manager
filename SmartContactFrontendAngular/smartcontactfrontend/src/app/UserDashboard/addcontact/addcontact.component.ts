import { Component, OnInit } from '@angular/core';
import { CKEditor5 } from '@ckeditor/ckeditor5-angular';
@Component({
  selector: 'app-addcontact',
  templateUrl: './addcontact.component.html',
  styleUrls: ['./addcontact.component.css']
})
export class AddcontactComponent implements OnInit {
  public editorContent = '<p>Hello, world!</p>';
  constructor() { }

  ngOnInit(): void {
  }

}
