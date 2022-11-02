package com.school.sms.api.service;

import com.school.sms.api.entity.Student;
import com.school.sms.api.entity.StudentEnrichment;
import com.school.sms.api.entity.Teacher;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public interface TeacherService {

     Teacher saveTeacher(Teacher teacher);
     List<Teacher> getAllTeacher();
     Teacher getTeacherById(Integer teacherId);
     void deleteTeacher(Integer teacherId);
     Teacher updateTeacherInfo(Teacher teacher,Integer teacherId);
     List<Student> getStudents(Teacher teacher, Integer teacherId);
     void addStudentEnrichment(Teacher teacher ,Integer studentId, StudentEnrichment studentEnrichment);
     void addStudent(Teacher teacher,Student student, Integer teacherID);
}
