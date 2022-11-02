package com.school.sms.api.service.implementation;

import com.school.sms.api.entity.Parent;
import com.school.sms.api.entity.Student;
import com.school.sms.api.entity.StudentEnrichment;
import com.school.sms.api.repository.ParentRepository;
import com.school.sms.api.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ParentServiceImplementation implements ParentService {
    @Autowired
    private ParentRepository parentRepository;

    @Override
    public Parent saveParent(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public List<Parent> getAllParent() {
        return parentRepository.findAll();
    }

    @Override
    public Parent getParentById(Integer parentId) {
        return parentRepository.getReferenceById(parentId);
    }

    @Override
    public String getFatherParentName(Integer parentId) {
        return parentRepository.findById(parentId).get().getFatherName();
    }

    @Override
    public String getMotherParentName(Integer parentId) {
        return parentRepository.findById(parentId).get().getMotherName();
    }

    @Override
    public Parent updateParentInfo(Parent parent, Integer parentId) {
        return parentRepository.findById(parentId)
                .map(parentToUpdate -> {
                   parentToUpdate.setFatherName(parent.getFatherName());
                   parentToUpdate.setMotherName(parent.getMotherName());
                   parentToUpdate.setMobileNumber(parent.getMobileNumber());
                   return parentRepository.save(parentToUpdate);
                }).orElseGet(()->{
                    return parentRepository.save(parent);
                });
    }

    @Override
    public void deleteParent(Parent parent) {
        parentRepository.delete(parent);
    }

    @Override
    public List<Student> getHisChild(Integer parentId) {
        return parentRepository.findById(parentId).get().getStudents();
    }

    @Override
    public void addChild(Parent parent, Student student, Integer parentId) {
        List<Student> students = parent.getStudents();
        students.add(student);
        parentRepository.findById(parentId).map(s->{
           s.setStudents(students);
           return parentRepository.save(s);
        });
    }

    @Override
    public List<StudentEnrichment> getStudentEnrichment(Integer parentId) {
        List<StudentEnrichment> studentEnrichments = parentRepository.findById(parentId).get()
                .getStudents().iterator().next().getStudentEnrichment();

        return studentEnrichments;
    }
}
