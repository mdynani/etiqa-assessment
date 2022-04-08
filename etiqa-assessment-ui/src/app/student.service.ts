import { Injectable } from '@angular/core'; 
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from './student';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private apiBaseUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getStudents(): Observable<Student[]>{
    return this.http.get<Student[]>(`${this.apiBaseUrl}/api/students`)
  }

  public getStudent(studentId : number): Observable<Student>{
    return this.http.get<Student>(`${this.apiBaseUrl}/api/students/${studentId}`)
  }

  public addStudent(student:any): Observable<Student>{
    return this.http.post<Student>(`${this.apiBaseUrl}/api/students`,student)
  }

  public updateStudent(student : any): Observable<Student>{
    return this.http.put<Student>(`${this.apiBaseUrl}/api/students`,student)
  }

  public deleteStudent(studentId : number): Observable<void>{
    return this.http.delete<void>(`${this.apiBaseUrl}/api/students/${studentId}`)
  }
}
