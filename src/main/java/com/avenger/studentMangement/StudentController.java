package com.avenger.studentMangement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

public class StudentController {

    @Autowired
    StudentService studentService;


      // getInformation
     @GetMapping("/get_student")
     public Student getstudent(@RequestParam("q") int admnNo){

        return studentService.getStudent(admnNo);
     }


       //UPPDATE INFORMATON
        @PutMapping("/update_student")
        public String uppdateInfo(@RequestParam("admnNo") int admnNo,@RequestParam("age") int age){

         return studentService.updateStudent(admnNo,age);

        }

          /*
          // delete data
          @DeleteMapping("/delete_info")
      public String deleteInfo(@RequestParam("q") int admnNo){

         if(!db.containsKey(admnNo)){
             return "ky delete karu halava";
         }else{
             db.remove(admnNo);
         }
           return "kar diya bhai delete";
      }
      */

      @DeleteMapping("/delete_student/{id}")
      public  String deleteStudent(@PathVariable("id") int id){
           return studentService.deleteStudent(id);
      }

    //ADDING THE INFORMATION
    @PostMapping("/add_student")
    public String addstudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
}
