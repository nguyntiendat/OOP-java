/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.hv;

import java.time.LocalDate;
/**
 *
 * @author admin
 */
public class Student {
    private static int count = 0;
    private int id = ++count;
    private String name;
    private LocalDate birthday;
    private double[] grade;
    
    public Student(){}
    public Student(String name, LocalDate bd){
        this.name = name;
        this.birthday = bd;
    }
    public Student(String name, String bd){
        this(name, LocalDate.parse(bd, Configuration.FORMATTER));
    }
    public void printStudent(){
        System.out.printf("%d - %s - %s\n", id, name, birthday.format(Configuration.FORMATTER));
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public double[] getGrade() {
        return grade;
    }
    public void setGrade(double[] grade) {
        this.grade = grade;
    }
    public void inputInforStudent(){
        System.out.println("Enter name: ");
        this.name = Configuration.SC.nextLine();
        System.out.println("Enter birthday: ");
        this.birthday = LocalDate.parse(Configuration.SC.nextLine(), Configuration.FORMATTER);
    }
}
