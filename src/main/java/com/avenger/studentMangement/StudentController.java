package com.avenger.studentMangement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

public class StudentController {

    @Autowired
    StudentService studentService;


      // getInformation
     @GetMapping("/get_student")
     public ResponseEntity getstudent(@RequestParam("q") int admnNo){

       Student student=  studentService.getStudent(admnNo);
       return new ResponseEntity<>(student, HttpStatus.FOUND);
     }


       //UPPDATE INFORMATON
        @PutMapping("/update_student")
        public ResponseEntity uppdateInfo(@RequestParam("admnNo") int admnNo,@RequestParam("age") int age){

           String responces=studentService.updateStudent(admnNo,age);
           if(responces==null){
               return new ResponseEntity<>("Invalied request",HttpStatus.BAD_REQUEST);
           }
              return  new ResponseEntity<>("Update",HttpStatus.ACCEPTED);
        }



      @DeleteMapping("/delete_student/{id}")
      public  ResponseEntity deleteStudent(@PathVariable("id") int id){
         String response= studentService.deleteStudent(id);
         if(response.equals("Invalid id")){
             return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
         }
           return  new ResponseEntity<>(response,HttpStatus.FOUND);
      }

    //ADDING THE INFORMATION
    @PostMapping("/add_student")
    public ResponseEntity addstudent(@RequestBody Student student){
        String response= studentService.addstudent(student);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
