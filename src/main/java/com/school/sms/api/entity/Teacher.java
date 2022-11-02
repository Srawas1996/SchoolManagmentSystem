package com.school.sms.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Teacher")
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacherId;
    private String teacherName;
    private String teacherPhoneNumber;
    private int age;
    private int classroomsFrom;
    private int classroomsTo;

    @ManyToMany
    private List<Student> student;


}
