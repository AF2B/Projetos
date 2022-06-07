import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-courseInfo',
  templateUrl: './courseInfo.component.html',
  styleUrls: ['./courseInfo.component.css']
})
export class CourseInfoComponent implements OnInit {

  courseId: any;

  constructor(private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.courseId = this.activatedRoute.snapshot.paramMap.get('id');
  }

}
