package com.school.sms.api.service.implementation;

import com.school.sms.api.entity.Student;
import com.school.sms.api.entity.StudentEnrichment;
import com.school.sms.api.repository.StudentEnrichmentRepository;
import com.school.sms.api.service.StudentEnrichmentService;
import com.school.sms.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StudentEnrichmentServiceImplementaion implements StudentEnrichmentService {
    @Autowired
    StudentEnrichmentRepository studentEnrichmentRepository;
    @Autowired
    StudentService studentService;

    @Override
    public StudentEnrichment save(StudentEnrichment studentEnrichment) {
        return studentEnrichmentRepository.save(studentEnrichment);
    }

    @Override
    public List<StudentEnrichment> getStudentEnrichment(Student student,Integer studentId) {
        return studentService.getStudentEnrichment(student,studentId);
    }
}
