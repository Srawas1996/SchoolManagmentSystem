package com.school.sms.api.repository;

import com.school.sms.api.entity.StudentEnrichment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnrichmentRepository extends JpaRepository<StudentEnrichment,Integer> {
}
