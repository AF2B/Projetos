import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss']
})
export class EventsComponent implements OnInit {

  widthImg: number = 150;
  marginImg: number = 2;
  showImg: boolean = true;
  private filterList: string = '';

  public events: any = [];
  public filteredEvents: any = [];
  private readonly apiURL: string = "https://localhost:5001";

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getEvents();
  }

  public getEvents(): void {
    this.http.get(`${this.apiURL}/api/events`).subscribe(
      response => this.events = response,
      this.filterEvents = this.events
    );
  }

  public hideImg() {
    this.showImg = !this.showImg;
  }

  public filterEvents(value: string): any {
    value = value.toLowerCase();

    return this.events.filter(
      (event: any) => event.theme.toLowerCase().indexOf(value) !== -1 || event.local.toLowerCase().indexOf(value) !== -1
    )
  }

  public get getFilterList(): string {
    return this.filterList
  }

  public set setFilterList(value: string) {
    this.filterList = value;
    this.events = this.filterList ? this.filterEvents(this.filterList) : this.filterList;
  }

}
