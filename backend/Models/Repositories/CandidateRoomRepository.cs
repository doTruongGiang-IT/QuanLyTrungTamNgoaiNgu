using backend.Models.Data;
using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public class CandidateRoomRepository : ICandidateRoomRepository
    {
        private QLTTNNContext context;
        public CandidateRoomRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public IEnumerable<CandidateRoomDTO> GetAll()
        {
            return this.context.candidate_rooms.ToList().ConvertToCandidateRoomDTO();
        }
        public CandidateRoomDTO Get(int id)
        {
            CandidateRoomDTO candidateRoomDTO = this.context.candidate_rooms.Find(id).ConvertToCandidateRoomDTO();
            return candidateRoomDTO;
        }
        public CandidateRoomDTO Create(CandidateRoomDTO candidateRoomDTO)
        {
            CandidateRoom candidateRoom = candidateRoomDTO.ConvertToCandidateRoom();
            this.context.candidate_rooms.Add(candidateRoom);
            this.context.SaveChanges();
            return candidateRoomDTO;
        }
        public void Update(CandidateRoomDTO candidateRoomDTO)
        {
            CandidateRoom candidateRoom = candidateRoomDTO.ConvertToCandidateRoom();
            this.context.candidate_rooms.Update(candidateRoom);
            this.context.SaveChanges();
        }
        public void Delete(int id)
        {
            var candidateRoom = this.context.candidate_rooms.Find(id);
            this.context.candidate_rooms.Remove(candidateRoom);
            this.context.SaveChanges();
        }

        public WebDTO GetInfor(string sbd)
        {
            CandidateRoom candidateRoom = this.context.candidate_rooms.Single(cr => cr.candidate_no==sbd);
            CandidateDTO candidate = this.context.candidates.Find(candidateRoom.candidate_id).ConvertToCandidateDTO();
            Room room = this.context.rooms.Find(candidateRoom.room_id);
            string time = "Afternoon";
            if(room.time)
            {
                time = "Morning";
            }
            ExaminationDTO examination = this.context.examinations.Find(room.examination_id).ConvertToExaminationDTO();
            ScheduleDTO schedule = new ScheduleDTO();
            schedule.examination = examination.name;
            schedule.level = room.level;
            schedule.room = room.name;
            schedule.date = examination.date;
            schedule.time = time;
            
            WebDTO webDTO = new WebDTO();
            webDTO.candidate = candidate;
            webDTO.schedule = schedule;
            webDTO.candidateRoom = candidateRoom.ConvertToCandidateRoomDTO();
            return webDTO;
        }
    }
}