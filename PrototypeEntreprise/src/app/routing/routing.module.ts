import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {HomePageComponent} from "../pages/home-page/home-page.component";
import {AnnuairePageComponent} from "../pages/annuaire-page/annuaire-page.component";
import {StagePageComponent} from "../pages/stage-page/stage-page.component";
import {EmploiPageComponent} from "../pages/emploi-page/emploi-page.component";
import {FormationPageComponent} from "../pages/formation-page/formation-page.component";
import {AssociationPageComponent} from "../pages/association-page/association-page.component";
import {AnnoncePageComponent} from "../pages/annonce-page/annonce-page.component";
import {NotFoundComponent} from "../pages/not-found/not-found.component";

const routes:Routes=[
  {
    path:'',
    component:HomePageComponent
  },
  {
    path:'',
    redirectTo:'',
    pathMatch:'full'
  },
  {
    path:'Annuaire',
    component:AnnuairePageComponent
  },
  {
    path:'Stages',
    component:StagePageComponent
  },
  {
    path:'Emploi',
    component:EmploiPageComponent
  },
  {
    path:'Formation',
    component:FormationPageComponent
  },
  {
    path:'Association',
    component:AssociationPageComponent
  },
  {
    path:'Annonces',
    component:AnnoncePageComponent
  },
  {
    path:'**',
    component:NotFoundComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],

})
export class RoutingModule { }
