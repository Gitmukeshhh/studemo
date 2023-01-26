package com.avenger.studentMangement;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer,Student> db=new HashMap();

    public  Student getStudent(int id){
        return db.get(id);
    }

    public String addStudent(Student student){
        int id=student.getAdmnNo();
        db.put(id,student);
        return "add sucessfully";
    }
    public  String deletStudent(int id){
        if(!db.containsKey(id)){
            return "Invalid id";
        }else{
            db.remove(id);
        }
         return "delete kar diya";
    }

     public String updateStudent(int id,int age){

        if(!db.containsKey(id)){
            return "invalied";
        }else{
            db.get(id).setAge(age);
        }
          return "add kar diya bhai";
     }

}
