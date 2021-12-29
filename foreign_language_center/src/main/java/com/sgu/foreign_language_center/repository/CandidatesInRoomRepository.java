package com.sgu.foreign_language_center.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sgu.foreign_language_center.entity.CandidatesInRoom;

@Repository
public interface CandidatesInRoomRepository extends JpaRepository<CandidatesInRoom, Long> {

	@Query(value="SELECT * FROM candidates_in_room r WHERE r.room_id=?1", nativeQuery = true)
	CandidatesInRoom findRoomById(long roomId);
	
	@Query(value="SELECT * FROM candidates_in_room c WHERE c.identity_card=?1", nativeQuery = true)
	CandidatesInRoom findCandidateByIdentityCard(long identityCard);
	
}
