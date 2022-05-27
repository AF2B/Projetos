import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss']
})
export class EventsComponent implements OnInit {

  public events: any;
  private readonly apiURL: string = "https://localhost:5001";

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getEvents();
  }

  public getEvents(): void {
    this.http.get(`${this.apiURL}/api/events`).subscribe(
      response => this.events = response
    );
  }

}
