using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public interface ICandidateRepository
    {
        IEnumerable<CandidateDTO> GetAll();
        CandidateDTO Get(int id);
        CandidateDTO Create(CandidateDTO candidate);
        void Update(CandidateDTO candidate);
        void Delete(int id);
        IEnumerable<CandidateDTO> GetByRoom(int room_id);
    }
}