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
            var result = this.context.candidate_rooms.Add(candidateRoom);
            this.context.SaveChanges();
            CandidateRoomDTO candidateRoomDTOResult = result.Entity.ConvertToCandidateRoomDTO();
            return candidateRoomDTOResult;
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

        public WebDTO GetInfor(string name, string phone)
        {
            Candidate candidate = this.context.candidates.SingleOrDefault(c => (c.first_name+" "+c.last_name)==name && c.phone==phone);
            List<CandidateRoom> candidateRooms = this.context.candidate_rooms.Where(cr => cr.candidate_id==candidate.id).ToList();
            CandidateDTO candidateDTO = candidate.ConvertToCandidateDTO();
            Room room = new Room();
            Examination examination = new Examination();
            CandidateRoom candidateRoom = new CandidateRoom();
            for(int i = (candidateRooms.Count-1); i >= 0; i--)
            {
                room = this.context.rooms.Find(candidateRooms[i].room_id);
                examination = this.context.examinations.Find(room.examination_id);
                if(!examination.registration_status)
                {
                    candidateRoom = candidateRooms[i];
                    break;
                }
            }
            Console.Write("Kim Bao");
            string time = "Afternoon";
            if(room.time)
            {
                time = "Morning";
            }
            ExaminationDTO examinationDTO = examination.ConvertToExaminationDTO();
            RoomDTO roomDTO = room.ConvertToRoomDTO();
            ScheduleDTO schedule = new ScheduleDTO();
            schedule.examination = examinationDTO.name;
            schedule.level = roomDTO.level;
            schedule.room = roomDTO.name;
            schedule.date = examinationDTO.date;
            schedule.time = time;
            
            WebDTO webDTO = new WebDTO();
            webDTO.candidate = candidate.ConvertToCandidateDTO();
            webDTO.schedule = schedule;
            webDTO.candidateRoom = candidateRoom.ConvertToCandidateRoomDTO();
            return webDTO;
        }
    }
}