package com.sgu.foreign_language_center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgu.foreign_language_center.entity.CandidatesInRoom;

@Repository
public interface CandidatesInRoomRepository extends JpaRepository<CandidatesInRoom, Long> {

}
