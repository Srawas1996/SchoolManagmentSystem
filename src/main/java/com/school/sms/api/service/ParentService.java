package com.school.sms.api.service;

import com.school.sms.api.entity.Parent;
import com.school.sms.api.entity.Student;
import com.school.sms.api.entity.StudentEnrichment;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ParentService {

    public abstract Parent saveParent(Parent parent);
    public abstract List<Parent> getAllParent();
    public abstract Parent getParentById(Integer parentId);
    public abstract String getFatherParentName(Integer parentId);
    public abstract String getMotherParentName(Integer parentId);
    public abstract Parent updateParentInfo(Parent parent, Integer parentId);
    public abstract void deleteParent(Integer parentId);
    public abstract List<Student> getHisChild(Integer parentId);
    public abstract void addChild(Parent parent,Student student,Integer parentId);
    public abstract List<StudentEnrichment> getStudentEnrichment(Integer parentId);
}
