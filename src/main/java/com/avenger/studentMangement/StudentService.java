package com.avenger.studentMangement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService{
    @Autowired
    StudentRepository studentRepository;
    public String addstudent(Student student){
        return  studentRepository.addStudent(student);
    }

    public String deleteStudent(int id){
        return studentRepository.deletStudent(id);
    }

    public String updateStudent(int id,int age){
       return   studentRepository.updateStudent(id,age);
    }

    public  Student getStudent(int id){
        return studentRepository.getStudent(id);
    }

}
