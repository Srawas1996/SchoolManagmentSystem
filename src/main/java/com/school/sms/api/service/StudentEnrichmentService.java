package com.school.sms.api.service;

import com.school.sms.api.entity.Student;
import com.school.sms.api.entity.StudentEnrichment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentEnrichmentService {
    public abstract StudentEnrichment save (StudentEnrichment studentEnrichment);
    public abstract List<StudentEnrichment> getStudentEnrichment(Student student,Integer studentId);

}
