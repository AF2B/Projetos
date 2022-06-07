import { Injectable } from "@angular/core";
import { ICourse } from "../interfaces/ICourse";

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  retrieveAll(): ICourse[] {
    return COURSES;
  }

}

var COURSES: ICourse[] = [
  {
    id: 1,
    name: 'Angular: CLI',
    releaseDate: 'June 25, 2022',
    description: 'Neste curso, os alunos irão obter um grande conhecimento nos principais recursos do CLI.',
    duration: 120,
    code: 'QWE-1212',
    rating: 3,
    price: 12.99,
    imageUrl: '/assets/images/cli.png',
  },
  {
    id: 2,
    name: 'Angular: Forms',
    releaseDate: 'August 4, 2021',
    description: 'Neste curso, os alunos irão obter um conhecimento aprofundado sobre os recursos disponíveis no módulo de Forms.',
    duration: 80,
    code: 'DWQ-3412',
    rating: 3.5,
    price: 24.99,
    imageUrl: '/assets/images/forms.png',
  },
  {
    id: 3,
    name: 'Angular: HTTP',
    releaseDate: 'November 16, 2022',
    description: 'Neste curso, os alunos irão obter um conhecimento aprofundado sobre os recursos disponíveis no módulo de HTTP.',
    duration: 80,
    code: 'ASD-0913',
    rating: 4.0,
    price: 36.99,
    imageUrl: '/assets/images/http.png',
  },
  {
    id: 4,
    name: 'Angular: Router',
    releaseDate: 'December 15, 2022',
    description: 'Neste curso, os alunos irão obter um conhecimento aprofundado sobre os recursos disponíveis no módulo de Router.',
    duration: 80,
    code: 'FGH-6695',
    rating: 4.5,
    price: 46.99,
    imageUrl: '/assets/images/router.png',
  },
  {
    id: 5,
    name: 'Angular: Animations',
    releaseDate: 'November 20, 2022',
    description: 'Neste curso, os alunos irão obter um conhecimento aprofundado sobre os recursos disponíveis sobre Animation.',
    duration: 80,
    code: 'VBN-9381',
    rating: 5,
    price: 56.99,
    imageUrl: '/assets/images/animations.png',
  }
]
