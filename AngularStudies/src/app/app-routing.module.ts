import { DirectivesComponent } from './components/directives/directives.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CourseInfoComponent } from './components/courseInfo/courseInfo.component';
import { PageNotFoundComponent } from './components/PageNotFound/PageNotFound.component';
import { TableComponent } from './components/table/table.component';

const routes: Routes = [
  {
    path: '', redirectTo: 'cursos', pathMatch: 'full'
  },
  {
    path: 'cursos', component: TableComponent
  },
  {
    path: 'cursos/info/:id', component: CourseInfoComponent
  },
  {
    path: 'diretivas', component: DirectivesComponent
  },
  {
    path: '**', component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: [

  ]
})
export class AppRoutingModule { }
