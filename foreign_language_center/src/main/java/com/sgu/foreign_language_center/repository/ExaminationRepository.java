package com.sgu.foreign_language_center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgu.foreign_language_center.entity.Examination;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {

}
