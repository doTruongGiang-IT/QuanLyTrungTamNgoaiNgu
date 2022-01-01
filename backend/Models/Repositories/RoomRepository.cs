using backend.Models.Data;

namespace backend.Models.Repositories
{
    public class RoomRepository : IRoomRepository
    {
        private QLTTNNContext context;
        public RoomRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public IEnumerable<Room> GetAll()
        {
            return this.context.rooms.ToList();
        }
        public Room Get(int id)
        {
            return this.context.rooms.Find(id);
        }
        public Room Create(Room room)
        {
            this.context.rooms.Add(room);
            this.context.SaveChanges();
            return room;
        }
        public void Update(Room room)
        {
            this.context.rooms.Update(room);
            this.context.SaveChanges();
        }
        public void Delete(int id)
        {
            var room = this.context.rooms.Find(id);
            this.context.rooms.Remove(room);
            this.context.SaveChanges();
        }
    }
}