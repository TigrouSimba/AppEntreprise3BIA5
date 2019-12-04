import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-stage-page',
  templateUrl: './stage-page.component.html',
  styleUrls: ['./stage-page.component.css']
})
export class StagePageComponent implements OnInit {

  selectedOption: string;
  check:boolean=false;

  private _eleves:any[]=[
    {
      name:"Stage à epicura"
    },
    {
      name:"Stage à la commune"
    },
    {
      name:"Stage à Microsoft"
    },
  ];

  private _eleves2:any[]=[
    {
      name:"Stage à Microsoft"
    }
  ];

  constructor() { }

  ngOnInit() {
  }

  options = [
    { name: "--Aucune--", value: "" },
    { name: "Comptabilité", value: "compta" },
    { name: "Informatique", value: "info" },
    { name: "Infographie", value: "infographie" },
    { name: "Electronique", value: "electro" },
    { name: "Tous", value: "all" }
  ]
  print() {
    this.eleves=this.eleves2;
  }


  get eleves(): any[] {
    return this._eleves;
  }

  @Input()
  set eleves(value: any[]) {
    this._eleves = value;
  }

  get eleves2(): any[] {
    return this._eleves2;
  }

  @Input()
  set eleves2(value: any[]) {
    this._eleves2 = value;
  }
}
