using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public interface IRoomRepository
    {
         IEnumerable<RoomDTO> GetAll();
         RoomDTO Get(int id);
         RoomDTO Create(RoomDTO roomDTO);
         void Update(RoomDTO roomDTO);
         void Delete(int id);
         IEnumerable<RoomDTO> GetByExam(int exmination_id);
         IEnumerable<RoomDTO> GetByExamLevel(int exmination_id, string level);
    }
}