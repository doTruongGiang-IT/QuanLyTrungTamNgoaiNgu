namespace backend.Models.Repositories
{
    public interface ICandidateRoomRepository
    {
         IEnumerable<CandidateRoom> GetAll();
         CandidateRoom Get(int id);
         CandidateRoom Create(CandidateRoom candidateRoom);
         void Update(CandidateRoom candidateRoom);
         void Delete(int id);
    }
}