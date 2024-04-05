/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.hv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class ManageStudent {
    private List<Student> studentList = new ArrayList<>();
    public void addStudent(Student hv){
        studentList.add(hv);
    }
    public void addStudent(Student... hv){
        studentList.addAll(Arrays.asList(hv));
    }
    public void addStudent(){
        Student student = new Student();
        student.inputInforStudent();
         studentList.add(student);
    }
    public void addStudent(String file) throws FileNotFoundException{
        File f = new File(file);
        try(Scanner scan = new Scanner(f)) {
            while(scan.hasNext()){
                studentList.add(new Student(scan.nextLine(), scan.nextLine()));
            }
        } 
    }
    public void printStudentList(){
        studentList.forEach(hv->hv.printStudent());
    }
   
}
