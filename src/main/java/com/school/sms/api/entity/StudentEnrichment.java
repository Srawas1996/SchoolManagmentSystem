package com.school.sms.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentEnrichment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int enrichmentId;
    private String soura;
    private String nextsoura;
    private int fromAya;
    private int toAya;
    private int nextDayAyaFrom;
    private int NextDayAyaTo;
    private String evaluation;
    private LocalDate date;

    @ManyToOne
    private Student student;
}
