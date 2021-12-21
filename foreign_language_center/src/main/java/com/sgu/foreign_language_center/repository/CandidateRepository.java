package com.sgu.foreign_language_center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgu.foreign_language_center.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
