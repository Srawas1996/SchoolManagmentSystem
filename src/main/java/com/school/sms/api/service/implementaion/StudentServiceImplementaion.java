package com.school.sms.api.service.implementaion;

import com.school.sms.api.entity.Parent;
import com.school.sms.api.entity.Student;
import com.school.sms.api.entity.StudentEnrichment;
import com.school.sms.api.entity.Teacher;
import com.school.sms.api.repository.StudentRepository;
import com.school.sms.api.service.StudentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImplementaion implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.getReferenceById(studentId);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudent(Student student, Integer studentId) {
        return studentRepository.findById(studentId)
                .map(studentToUpdate -> {
                    studentToUpdate.setAge(student.getAge());
                    studentToUpdate.setMobileNumber(student.getMobileNumber());
                    studentToUpdate.setStudentEnrichment(student.getStudentEnrichment());
                    studentToUpdate.setParents(student.getParents());
                    studentToUpdate.setTeachers(student.getTeachers());
                    studentToUpdate.setFirstName(student.getFirstName());
                    studentToUpdate.setLastName(student.getLastName());
                    return studentRepository.save(studentToUpdate);
                }).orElseGet(() -> {
                   return studentRepository.save(student);
                });
    }

    @Override
    public Parent getParent(Student student, Integer studentId) {
        return studentRepository.findById(studentId).get().getParents();
    }

    @Override
    public List<StudentEnrichment> getStudentEnrichment(Student student, Integer studentId) {
        return studentRepository.findById(studentId).get().getStudentEnrichment();
    }

    @Override
    public List<Teacher> getTeachers(Student student,Integer studentId) {
        return studentRepository.findById(studentId).get().getTeachers();
    }

    @Override
    public void addTeacher(Teacher teacher, @NotNull Student student, Integer studentId) {
        List<Teacher> teachers = student.getTeachers();
        teachers.add(teacher);
        studentRepository.findById(studentId).map(s->{
            s.setTeachers(teachers);
            return studentRepository.save(s);
        });
    }
}
