using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public interface ICandidateRoomRepository
    {
        IEnumerable<CandidateRoomDTO> GetAll();
        CandidateRoomDTO Get(int id);
        CandidateRoomDTO Create(CandidateRoomDTO candidateRoomDTO);
        void Update(CandidateRoomDTO candidateRoomDTO);
        void Delete(int id);
        WebDTO GetInfor(string sbd);
    }
}