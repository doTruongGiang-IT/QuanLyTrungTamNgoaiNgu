using backend.Models.Data;
using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public class CandidateRepository : ICandidateRepository
    {
        private QLTTNNContext context;
        public CandidateRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public CandidateDTO Create(CandidateDTO candidateDTO)
        {
            Candidate candidate = this.context.candidates.SingleOrDefault(c => c.identification==candidateDTO.identification);
            if(candidate != null)
            {
                DateTime issue_olddate = DateTime.Parse(candidateDTO.issue_date);
                DateTime issue_newdate = DateTime.SpecifyKind(issue_olddate, DateTimeKind.Utc);
                DateTime birth_olddate = DateTime.Parse(candidateDTO.date_of_birth);
                DateTime birth_newdate = DateTime.SpecifyKind(birth_olddate, DateTimeKind.Utc);
                candidate.issue_date = issue_newdate;
                candidate.issue_place = candidateDTO.issue_place;
                candidate.email = candidateDTO.email;
                candidate.first_name = candidateDTO.first_name;
                candidate.last_name = candidateDTO.last_name;
                candidate.gender = candidateDTO.gender;
                candidate.date_of_birth = birth_newdate;
                candidate.place_of_birth = candidateDTO.place_of_birth;
                candidate.phone = candidateDTO.phone;
                this.context.candidates.Update(candidate);
                this.context.SaveChanges();
                return candidate.ConvertToCandidateDTO();
            }
            Candidate newCandidate = candidateDTO.ConvertToCandidate();
            var result = this.context.candidates.Add(newCandidate);
            this.context.SaveChanges();
            CandidateDTO candidateDTOReusult = result.Entity.ConvertToCandidateDTO();
            return candidateDTOReusult;
;
        }

        public void Delete(int id)
        {
            var candidate = this.context.candidates.Find(id);
            this.context.candidates.Remove(candidate);
            this.context.SaveChanges();
        }

        public CandidateDTO Get(int id)
        {
            CandidateDTO candidateDTO = this.context.candidates.Find(id).ConvertToCandidateDTO();
            return candidateDTO;
        }

        public IEnumerable<CandidateDTO> GetAll()
        {
            return this.context.candidates.ToList().ConvertToCandidateDTO();
        }

        public void Update(CandidateDTO candidateDTO)
        {   Candidate candidate = candidateDTO.ConvertToCandidate();
            this.context.candidates.Update(candidate);
            this.context.SaveChanges();
        }

        public IEnumerable<CandidateDTO> GetByRoom(int room_id)
        {
            List<CandidateDTO> candidateDTOs = new List<CandidateDTO>();
            bool flag = true;
            IEnumerable<CandidateRoom> candidateRooms = this.context.candidate_rooms.Where(cr => cr.room_id==room_id).ToList();
            foreach(CandidateRoom candidateRoom in candidateRooms)
            {
                CandidateDTO candidateDTO = this.Get(candidateRoom.candidate_id);
                candidateDTOs.Add(candidateDTO);
            }
            IEnumerable<CandidateDTO> eCandidateDTOs = candidateDTOs as IEnumerable<CandidateDTO>;
            return eCandidateDTOs;
        }
    }
}