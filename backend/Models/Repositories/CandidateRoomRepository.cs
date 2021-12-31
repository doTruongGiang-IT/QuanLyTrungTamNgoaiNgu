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
    }
}