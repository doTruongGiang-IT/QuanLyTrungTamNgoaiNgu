using backend.Models.Data;

namespace backend.Models.Repositories
{
    public class CandidateRoomRepository : ICandidateRoomRepository
    {
        private QLTTNNContext context;
        public CandidateRoomRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public IEnumerable<CandidateRoom> GetAll()
        {
            return this.context.candidate_rooms.ToList();
        }
        public CandidateRoom Get(int id)
        {
            return this.context.candidate_rooms.Find(id);
        }
        public CandidateRoom Create(CandidateRoom candidateRoom)
        {
            this.context.candidate_rooms.Add(candidateRoom);
            this.context.SaveChanges();
            return candidateRoom;
        }
        public void Update(CandidateRoom candidateRoom)
        {
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