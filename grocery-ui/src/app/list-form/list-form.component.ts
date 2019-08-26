import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'list-form',
  templateUrl: './list-form.component.html',
  styleUrls: ['./list-form.component.css']
})
export class ListFormComponent implements OnInit {

  item: String;
  itemType: String;


  constructor() { }

  ngOnInit() {
    this.item = null;
    this.itemType = null;
  }

}
