import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';

import { ErrorComponent } from './../../shared/components/error/error.component';
import { Course } from './../model/course';
import { CoursesService } from './../services/courses.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  courses$ : Observable <Course[]>;
  displayedColumns = ['name','category'];

  constructor(private coursesService : CoursesService,
    public dialog: MatDialog) {
    this.courses$ = this.coursesService.list().pipe(
      catchError(error => {
        this.onError("Erro ao carregar os cursos");
        return of([])
      })
    );
  }

  ngOnInit(): void {

  }
  onError(errorMsg : string){
    this.dialog.open(ErrorComponent, {
      data: errorMsg,
    });
  }
}
