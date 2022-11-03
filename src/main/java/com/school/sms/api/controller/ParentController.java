package com.school.sms.api.controller;

import com.school.sms.api.entity.Parent;
import com.school.sms.api.entity.Student;
import com.school.sms.api.entity.StudentEnrichment;
import com.school.sms.api.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/SchoolManagementSystem/Parent", produces = MediaType.APPLICATION_JSON_VALUE)
public class ParentController {

    @Autowired
    private ParentService parentService;

    @GetMapping(value = "/parentList")
    public List<Parent> parents(){
        return parentService.getAllParent();
    }

    @GetMapping(value = "/studentList")
    public List<Student> students(@Valid @RequestBody Integer parentId){
        return parentService.getHisChild(parentId);
    }

    @PostMapping(value = "/saveParent")
    public Parent saveNewParent(@Valid @RequestBody Parent parent){
        return parentService.saveParent(parent);
    }

    @PutMapping(value = "/addChild")
    public void addStudent(Parent parent,Student student,Integer parentId){
        parentService.addChild(parent,student,parentId);
    }

    @GetMapping(value = "/getParent/{parentId}")
    public Parent getParentById(@PathVariable Integer parentId){
        return parentService.getParentById(parentId);
    }

    @GetMapping(value = "/getFatherName/{parentId}")
    public String getFatherName(@PathVariable Integer parentId){
        return parentService.getFatherParentName(parentId);
    }

    @GetMapping(value = "/getMotherName/{parentId}")
    public String getMotherName(@PathVariable Integer parentId){
        return parentService.getMotherParentName(parentId);
    }

    @PutMapping(value = "/updateParent/{parentId}")
    public Parent updateParentInfo(Parent parent,@PathVariable Integer parentId){
        return parentService.updateParentInfo(parent,parentId);
    }

    @DeleteMapping(value = "/deleteParent/{parentId}")
    public void deleteParent(@PathVariable Integer parentId){
        parentService.deleteParent(parentId);
    }

    @GetMapping(value = "/getStudentEnrichment/{parentId}")
    public List<StudentEnrichment> getStudentEnrichment(@PathVariable Integer parentId){
        return parentService.getStudentEnrichment(parentId);
    }










}
