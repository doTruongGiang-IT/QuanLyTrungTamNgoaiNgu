using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public interface ISupervisorRepository
    {
         IEnumerable<SupervisorDTO> GetAll();
         SupervisorDTO Get(int id);
         SupervisorDTO Create(SupervisorDTO supervisorDTO);
         void Update(SupervisorDTO supervisorDTO);
         void Delete(int id);
    }
}