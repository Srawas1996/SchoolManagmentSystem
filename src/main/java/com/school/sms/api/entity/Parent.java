package com.school.sms.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Parent")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer parentId;


    @Column(name = "father_name")
    @NotNull
    @NotBlank
    private String fatherName;

    @Column(name = "mother_name")
    @NotNull
    @NotBlank
    private String motherName;


    @NotNull
    @NotBlank
    @Column(unique = true,name = "Mobile")
    private Long mobileNumber;

    @OneToMany(mappedBy = "parents")
    private List<Student> students;
}
