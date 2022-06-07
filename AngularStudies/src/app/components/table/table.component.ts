import { Component, OnInit } from '@angular/core';
import { CourseService } from 'src/app/services/courses.service';
import { ICourse } from 'src/app/interfaces/ICourse';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  _courses: ICourse[] = [];
  _filterBy: string = '';
  filteredCourses: ICourse[] = [];


  constructor(private courseService: CourseService) { }

  ngOnInit() {
    this._courses = this.courseService.retrieveAll();
    this.filteredCourses = this._courses;
  }

  set filter(value: string) {
    this._filterBy = value;

    this.filteredCourses = this._courses.filter((course: ICourse) => course.name.toLowerCase().indexOf(this._filterBy.toLocaleLowerCase()) > -1);
  }

  get filter() {
    return this._filterBy;
  }

}
