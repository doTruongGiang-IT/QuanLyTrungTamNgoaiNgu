namespace backend.Models.DTOs
{
    public static class Mapper
    {
        public static Examination ConvertToExamination(this ExaminationDTO examinationDTO)
        {   
            DateTime olddate = DateTime.Parse(examinationDTO.date);
            DateTime newdate = DateTime.SpecifyKind(olddate, DateTimeKind.Utc);
            return new Examination()
            {
                id = examinationDTO.id,
                name = examinationDTO.name,
                date = newdate,
                registration_status = examinationDTO.registration_status
            };
        }

        public static ExaminationDTO ConvertToExaminationDTO(this Examination examination)
        {
            return new ExaminationDTO()
            {
                id = examination.id,
                name = examination.name,
                date = examination.date.ToString("yyyy'-'MM'-'dd"),
                registration_status = examination.registration_status
            };
        }

        public static IEnumerable<ExaminationDTO> ConvertToExaminationDTO(this IEnumerable<Examination> examinations)
        {
            return examinations.Select(examination => examination.ConvertToExaminationDTO());
        }

        public static Candidate ConvertToCandidate(this CandidateDTO candidateDTO)
        {
            DateTime issue_olddate = DateTime.Parse(candidateDTO.issue_date);
            DateTime issue_newdate = DateTime.SpecifyKind(issue_olddate, DateTimeKind.Utc);
            DateTime birth_olddate = DateTime.Parse(candidateDTO.date_of_birth);
            DateTime birth_newdate = DateTime.SpecifyKind(birth_olddate, DateTimeKind.Utc);
            return new Candidate()
            {
                id = candidateDTO.id,
                identification = candidateDTO.identification,
                issue_date = issue_newdate,
                issue_place = candidateDTO.issue_place,
                email = candidateDTO.email,
                first_name = candidateDTO.first_name,
                last_name = candidateDTO.last_name,
                gender = candidateDTO.gender,
                date_of_birth = birth_newdate,
                place_of_birth = candidateDTO.place_of_birth,
                phone = candidateDTO.phone
            };
        }

        public static CandidateDTO ConvertToCandidateDTO(this Candidate candidate)
        {
            return new CandidateDTO()
            {
                id = candidate.id,
                identification = candidate.identification,
                issue_date = candidate.issue_date.ToString("yyyy'-'MM'-'dd"),
                issue_place = candidate.issue_place,
                email = candidate.email,
                first_name = candidate.first_name,
                last_name = candidate.last_name,
                gender = candidate.gender,
                date_of_birth = candidate.date_of_birth.ToString("yyyy'-'MM'-'dd"),
                place_of_birth = candidate.place_of_birth,
                phone = candidate.phone
            };
        }

        public static IEnumerable<CandidateDTO> ConvertToCandidateDTO(this IEnumerable<Candidate> candidates)
        {
            return candidates.Select(candidate => candidate.ConvertToCandidateDTO());
        }

        public static Room ConvertToRoom(this RoomDTO roomDTO)
        {
            return new Room()
            {
                id = roomDTO.id,
                name = roomDTO.name,
                examination_id = roomDTO.examination_id,
                level = roomDTO.level,
                time = roomDTO.time
            };
        }

        public static RoomDTO ConvertToRoomDTO(this Room room)
        {
            return new RoomDTO()
            {
                id = room.id,
                name = room.name,
                examination_id = room.examination_id,
                level = room.level,
                time = room.time
            };
        }

        public static IEnumerable<RoomDTO> ConvertToRoomDTO(this IEnumerable<Room> rooms)
        {
            return rooms.Select(room => room.ConvertToRoomDTO());
        }

        public static Supervisor ConvertToSupervisor(this SupervisorDTO supervisorDTO)
        {
            return new Supervisor()
            {
                id = supervisorDTO.id,
                name = supervisorDTO.name
            };
        }

        public static SupervisorDTO ConverToSupervisorDTO(this Supervisor supervisor)
        {
            return new SupervisorDTO()
            {
                id = supervisor.id,
                name = supervisor.name
            };
        }

        public static IEnumerable<SupervisorDTO> ConverToSupervisorDTO(this IEnumerable<Supervisor> supervisors)
        {
            return supervisors.Select(supervisor => supervisor.ConverToSupervisorDTO());
        }

        public static RegistrationForm ConvertToRegistrationForm(this RegistrationFormDTO registrationFormDTO)
        {
            return new RegistrationForm()
            {
                id = registrationFormDTO.id,
                candidate_id = registrationFormDTO.candidate_id,
                examination_id = registrationFormDTO.examination_id,
                level = registrationFormDTO.level,
                status = registrationFormDTO.status
            };
        }

        public static RegistrationFormDTO ConvertToRegistrationFormDTO(this RegistrationForm registrationForm)
        {
            return new RegistrationFormDTO()
            {
                id = registrationForm.id,
                candidate_id = registrationForm.candidate_id,
                examination_id = registrationForm.examination_id,
                level = registrationForm.level,
                status = registrationForm.status
            };
        }

        public static IEnumerable<RegistrationFormDTO> ConvertToRegistrationFormDTO(this IEnumerable<RegistrationForm> registrationForms)
        {
            return registrationForms.Select(registrationForm => registrationForm.ConvertToRegistrationFormDTO());
        }

        public static CandidateRoom ConvertToCandidateRoom(this CandidateRoomDTO candidateRoomDTO)
        {
            return new CandidateRoom()
            {
                id = candidateRoomDTO.id,
                candidate_id = candidateRoomDTO.candidate_id,
                candidate_no = candidateRoomDTO.candidate_no,
                room_id = candidateRoomDTO.room_id,
                score_listening = candidateRoomDTO.score_listening,
                score_speaking = candidateRoomDTO.score_speaking,
                score_writing = candidateRoomDTO.score_writing,
                score_reading = candidateRoomDTO.score_reading
            };
        }

        public static CandidateRoomDTO ConvertToCandidateRoomDTO(this CandidateRoom candidateRoom)
        {
            return new CandidateRoomDTO()
            {
                id = candidateRoom.id,
                candidate_id = candidateRoom.candidate_id,
                candidate_no = candidateRoom.candidate_no,
                room_id = candidateRoom.room_id,
                score_listening = candidateRoom.score_listening,
                score_speaking = candidateRoom.score_speaking,
                score_writing = candidateRoom.score_writing,
                score_reading = candidateRoom.score_reading
            };
        }

         public static IEnumerable<CandidateRoomDTO> ConvertToCandidateRoomDTO(this IEnumerable<CandidateRoom> candidateRooms)
         {
             return candidateRooms.Select(candidateRoom => candidateRoom.ConvertToCandidateRoomDTO());
         }

         public static SupervisorRoom ConvertToSupervisorRoom(this SupervisorRoomDTO supervisorRoomDTO)
         {
             return new SupervisorRoom()
             {
                 id = supervisorRoomDTO.id,
                 supervisor_id = supervisorRoomDTO.supervisor_id,
                 room_id = supervisorRoomDTO.room_id
             };
         }

         public static SupervisorRoomDTO ConvertToSupervisorRoomDTO(this SupervisorRoom supervisorRoom)
         {
             return new SupervisorRoomDTO()
             {
                 id = supervisorRoom.id,
                 supervisor_id = supervisorRoom.supervisor_id,
                 room_id = supervisorRoom.room_id
             };
         }

         public static IEnumerable<SupervisorRoomDTO> ConvertToSupervisorRoomDTO(this IEnumerable<SupervisorRoom> supervisorRooms)
         {
             return supervisorRooms.Select(supervisorRoom => supervisorRoom.ConvertToSupervisorRoomDTO());
         }
    }
}