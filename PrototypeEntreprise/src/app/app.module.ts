import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {NgbCollapseModule, NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { HomePageComponent } from './pages/home-page/home-page.component';
import { AnnuairePageComponent } from './pages/annuaire-page/annuaire-page.component';
import { StagePageComponent } from './pages/stage-page/stage-page.component';
import { EmploiPageComponent } from './pages/emploi-page/emploi-page.component';
import { FormationPageComponent } from './pages/formation-page/formation-page.component';
import { AssociationPageComponent } from './pages/association-page/association-page.component';
import { AnnoncePageComponent } from './pages/annonce-page/annonce-page.component';
import {NotFoundComponent} from "./pages/not-found/not-found.component";
import {RouterModule} from "@angular/router";
import {RoutingModule} from "./routing/routing.module";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    AnnuairePageComponent,
    StagePageComponent,
    EmploiPageComponent,
    FormationPageComponent,
    AssociationPageComponent,
    AnnoncePageComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    NgbModule,
    NgbCollapseModule,
    NgbCollapseModule,
    RouterModule,
    RoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
