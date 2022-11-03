package com.school.sms.api.service.implementation;

import com.school.sms.api.entity.Student;
import com.school.sms.api.entity.StudentEnrichment;
import com.school.sms.api.entity.Teacher;
import com.school.sms.api.repository.TeacherRepository;
import com.school.sms.api.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class TeacherServiceImplementation implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Integer teacherId) {
        return teacherRepository.getReferenceById(teacherId);
    }

    @Override
    public void deleteTeacher(Integer teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    @Override
    public Teacher updateTeacherInfo(Teacher teacher, Integer teacherId) {
        return teacherRepository.findById(teacherId).map(teacherToUpdate ->{
            teacherToUpdate.setTeacherName(teacher.getTeacherName());
            teacherToUpdate.setAge(teacher.getAge());
            teacherToUpdate.setClassroomsFrom(teacher.getClassroomsFrom());
            teacherToUpdate.setClassroomsTo(teacher.getClassroomsTo());
            teacherToUpdate.setTeacherPhoneNumber(teacher.getTeacherPhoneNumber());

            return teacherRepository.save(teacherToUpdate);
        }).orElseGet(()->{
            return teacherRepository.save(teacher);
        });
    }

    @Override
    public List<Student> getStudents(Teacher teacher, Integer teacherId) {
        return teacherRepository.findById(teacherId).get().getStudent();
    }

    @Override
    public void addStudentEnrichment(Teacher teacher ,Integer studentId, StudentEnrichment studentEnrichment) {
        List<StudentEnrichment> studentEnrichments = teacher.getStudent().get(studentId).getStudentEnrichment();
        studentEnrichments.add(studentEnrichment);
        teacherRepository.findById(teacher.getTeacherId()).map(s-> {
            s.getStudent().get(studentId).setStudentEnrichment(studentEnrichments);
            return teacherRepository.save(s);
        });
    }

    @Override
    public void addStudent(Teacher teacher, Student student,Integer teacherId) {
        List<Student> students = teacher.getStudent();
        students.add(student);
        teacherRepository.findById(teacherId).map(s->{
           s.setStudent(students);
           return teacherRepository.save(s);
        });
    }
}
