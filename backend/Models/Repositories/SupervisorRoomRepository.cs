using backend.Models.Data;

namespace backend.Models.Repositories
{
    public class SupervisorRoomRepository : ISupervisorRoomRepository
    {
        private QLTTNNContext context;
        public SupervisorRoomRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public IEnumerable<SupervisorRoom> GetAll()
        {
            return this.context.supervisor_rooms.ToList();
        }
        public SupervisorRoom Get(int id)
        {
            return this.context.supervisor_rooms.Find(id);
        }
        public SupervisorRoom Create(SupervisorRoom supervisorRoom)
        {
            this.context.supervisor_rooms.Add(supervisorRoom);
            this.context.SaveChanges();
            return supervisorRoom;
        }
        public void Update(SupervisorRoom supervisorRoom)
        {
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