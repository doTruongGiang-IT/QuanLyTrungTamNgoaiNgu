using backend.Models.Data;
using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public class SupervisorRepository : ISupervisorRepository
    {

        private QLTTNNContext context;
        public SupervisorRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public IEnumerable<SupervisorDTO> GetAll()
        {
            return this.context.supervisors.ToList().ConverToSupervisorDTO();
        }
        public SupervisorDTO Get(int id)
        {
            return this.context.supervisors.Find(id).ConverToSupervisorDTO();
        }
        public SupervisorDTO Create(SupervisorDTO supervisorDTO)
        {
            Supervisor supervisor = supervisorDTO.ConvertToSupervisor();
            this.context.supervisors.Add(supervisor);
            this.context.SaveChanges();
            return supervisorDTO;
        }
        public void Update(SupervisorDTO supervisorDTO)
        {
            Supervisor supervisor = supervisorDTO.ConvertToSupervisor();
            this.context.supervisors.Update(supervisor);
            this.context.SaveChanges();
        }
        public void Delete(int id)
        {
            var supervisor = this.context.supervisors.Find(id);
            this.context.supervisors.Remove(supervisor);
            this.context.SaveChanges();
        }
    }
}