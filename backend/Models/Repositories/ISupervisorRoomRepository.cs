using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public interface ISupervisorRoomRepository
    {
         IEnumerable<SupervisorRoomDTO> GetAll();
         SupervisorRoomDTO Get(int id);
         SupervisorRoomDTO Create(SupervisorRoomDTO supervisorRoomDTO);
         void Update(SupervisorRoomDTO supervisorRoomDTO);
         void Delete(int id);
    }
}