using backend.Models.Data;
using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public class SupervisorRoomRepository : ISupervisorRoomRepository
    {
        private QLTTNNContext context;
        public SupervisorRoomRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public IEnumerable<SupervisorRoomDTO> GetAll()
        {
            return this.context.supervisor_rooms.ToList().ConvertToSupervisorRoomDTO();
        }
        public SupervisorRoomDTO Get(int id)
        {
            return this.context.supervisor_rooms.Find(id).ConvertToSupervisorRoomDTO();
        }
        public SupervisorRoomDTO Create(SupervisorRoomDTO supervisorRoomDTO)
        {
            SupervisorRoom supervisorRoom = supervisorRoomDTO.ConvertToSupervisorRoom();
            this.context.supervisor_rooms.Add(supervisorRoom);
            this.context.SaveChanges();
            return supervisorRoomDTO;
        }
        public void Update(SupervisorRoomDTO supervisorRoomDTO)
        {
            SupervisorRoom supervisorRoom = supervisorRoomDTO.ConvertToSupervisorRoom();
            this.context.supervisor_rooms.Update(supervisorRoom);
            this.context.SaveChanges();
        }
        public void Delete(int id)
        {
            var supervisorRoom = this.context.supervisor_rooms.Find(id);
            this.context.supervisor_rooms.Remove(supervisorRoom);
            this.context.SaveChanges();
        }
    }
}