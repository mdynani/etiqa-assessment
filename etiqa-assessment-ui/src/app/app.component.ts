import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Student } from './student';
import { StudentService } from './student.service';
import { NgForm } from '@angular/forms';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Course } from './course';
import { CourseService } from './course.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'etiqa-assessment-ui';
  public students: Student[] = [];
  public courses: Course[] = [];
  public editStudent: Student;
  public deleteStudent: Student;

  constructor(private studentService: StudentService, private courseService: CourseService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getStudents();
    this.getCourses();
  }

  public getStudents(): void {
    this.studentService.getStudents().subscribe(
      (response: Student[]) => {
        this.students = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public getCourses(): void {
    this.courseService.getCourses().subscribe(
      (response: Course[]) => {
        this.courses = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public onAddStudent(addForm: NgForm): void {
    console.log(addForm.value);
    const tempData: { [x: string]: any } = {};
    tempData['name'] = addForm.value.name;
    tempData['email'] = addForm.value.email;
    tempData['identification'] = addForm.value.identification;
    tempData['course'] = {
      'id': addForm.value.course
    } 
    this.studentService.addStudent(tempData).subscribe(
      (response: Student) => {
        console.log(response);
        this.getStudents();
        addForm.reset(); 
        this.modalService.dismissAll();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateStudent(student: Student): void {
    console.log(student);
    const tempData: { [x: string]: any } = {};
    tempData['id']  = student.id;
    tempData['name'] = student.name;
    tempData['email'] = student.email;
    tempData['identification'] = student.identification;
    tempData['course'] = {
      'id': student.course
    } 
    this.studentService.updateStudent(tempData).subscribe(
      (response: Student) => {
        console.log(response);
        this.getStudents();
        this.modalService.dismissAll();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteStudent(studentId: number): void {
    this.studentService.deleteStudent(studentId).subscribe(
      (response: void) => {
        console.log(response);
        this.getStudents();
        this.modalService.dismissAll();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(content: any, student: Student, mode: string): void {
    console.log(student);
    console.log(mode);
    if (mode === 'add') {
      this.modalService.open(content, { ariaLabelledBy: 'addStudentModalLabel' });
    }
    if (mode === 'edit') {
      this.editStudent = student;
      this.modalService.open(content, { ariaLabelledBy: 'updateStudentModalLabel' });
    }
    if (mode === 'delete') {
      this.deleteStudent = student;
      this.modalService.open(content, { ariaLabelledBy: 'deleteStudentModalLabel' });
    }
  }

  openAddModal(content: any) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-title' }).result.then((result) => {
    });
  }

  open(content: any, student: Student) {
    console.log(student);
    this.editStudent = student;
    this.deleteStudent = student;
    this.modalService.open(content, { ariaLabelledBy: 'modal-title' }).result.then((result) => {
    });
  }

}
