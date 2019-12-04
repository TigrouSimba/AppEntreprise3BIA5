import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-annuaire-page',
  templateUrl: './annuaire-page.component.html',
  styleUrls: ['./annuaire-page.component.css']
})
export class AnnuairePageComponent implements OnInit {

  selectedOption: string;
  check:boolean=false;

  private _eleves:any[]=[
    {
      name:"Joseph Joestar"
    },
    {
      name:"Robert Speedwagon"
    },
    {
      name:"Dio Brando"
    },
  ];

  private _eleves2:any[]=[
    {
      name:"Joseph Joestar"
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
