import { Course } from "./course";

export interface Student{
    id:number;
    name:string;
    email:string;
    identification:string
    course:Course
}