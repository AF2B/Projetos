import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { ReplacePipe } from './shared/pipe/replace.pipe';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { TableComponent } from './components/table/table.component';
import { NavBarComponent } from './core/components/nav-bar/nav-bar.component';
import { PageNotFoundComponent } from './components/PageNotFound/PageNotFound.component';
import { CourseInfoComponent } from './components/courseInfo/courseInfo.component';
import { StarRatingComponent } from './shared/components/starRating/starRating.component';

@NgModule({
  declarations: [
    AppComponent,
    TableComponent,
    ReplacePipe,
    NavBarComponent,
    PageNotFoundComponent,
    CourseInfoComponent,
    StarRatingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FontAwesomeModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
