import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-starRating',
  templateUrl: './starRating.component.html',
  styleUrls: ['./starRating.component.css']
})
export class StarRatingComponent implements OnChanges {

  @Input()
  rating: number = 0;

  starWidth: number = 0;

  constructor() { }

  ngOnChanges(changes: SimpleChanges): void {
    this.starWidth = this.rating * 74 / 5
  }

}
