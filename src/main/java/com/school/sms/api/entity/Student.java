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
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_Id")
    private Long studentId;

    @Column(name = "first_name")
    @NotNull
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @NotBlank
    private String lastName;

    @NotBlank
    @NotNull
    @Column(name = "age")
    private int age;

    @NotNull
    @NotBlank
    @Column(name = "Mobile")
    private Long mobileNumber;

    @ManyToOne
    @JoinColumn(name = "parentId")
    private Parent parents;

    @ManyToMany
    @JoinTable(
            name = "Student_Teacher",
            joinColumns = @JoinColumn(name = "Student_Id"),
            inverseJoinColumns = @JoinColumn(name = "Teacher_Id")
    )
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "student")
    private List<StudentEnrichment> studentEnrichment;

}
