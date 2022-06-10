import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {
  text = '';

  count = 0;
  pessoas = [{
    nome: 'André Filipe',
    sobrenome: 'Fonsêca Borba'
  }];

  constructor() { }

  ngOnInit() {
    this.countPlus();
  }

  countPlus() {
    let interval = setInterval(() => {
      this.count++;
      if (this.count === 10) {
        clearInterval(interval);
      }
    }, 1200);
  }

  click(){
    console.log("Botão clicado");
  }

}
