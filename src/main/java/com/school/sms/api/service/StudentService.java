package com.school.sms.api.service;

import com.school.sms.api.entity.Parent;
import com.school.sms.api.entity.Student;
import com.school.sms.api.entity.StudentEnrichment;
import com.school.sms.api.entity.Teacher;
import org.springframework.stereotype.Service;


import java.util.List;


public interface StudentService {

    public abstract Student saveStudent(Student student);
    public abstract List<Student> getAllStudent();
    public abstract Student getStudentById(Integer studentId);
    public abstract void deleteStudent(Integer studentId);
    public abstract Student updateStudent(Student student,Integer studentId);

    public abstract Parent getParent(Student student,Integer studentId);
    public abstract List<StudentEnrichment> getStudentEnrichment(Student student,Integer studentId);
    public abstract List<Teacher> getTeachers(Student student,Integer studentId);

    public abstract void addTeacher(Teacher teacher,Student student,Integer studentId);

}
