import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-emploi-page',
  templateUrl: './emploi-page.component.html',
  styleUrls: ['./emploi-page.component.css']
})
export class EmploiPageComponent implements OnInit {

  selectedOption: string;
  check:boolean=false;

  private _eleves:any[]=[
    {
      name:"Emploi à BNP"
    },
    {
      name:"Emploi à Google"
    },
    {
      name:"Emploi à Microsoft"
    },
  ];

  private _eleves2:any[]=[
    {
      name:"Emploi à Google"
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
