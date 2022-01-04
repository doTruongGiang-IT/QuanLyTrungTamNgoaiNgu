using backend.Models.Data;
using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public class RoomRepository : IRoomRepository
    {
        private QLTTNNContext context;
        public RoomRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public IEnumerable<RoomDTO> GetAll()
        {
            return this.context.rooms.ToList().ConvertToRoomDTO();
        }
        public RoomDTO Get(int id)
        {
            return this.context.rooms.Find(id).ConvertToRoomDTO();
        }
        public RoomDTO Create(RoomDTO roomDTO)
        {
            Room room = roomDTO.ConvertToRoom();
            this.context.rooms.Add(room);
            this.context.SaveChanges();
            return roomDTO;
        }
        public void Update(RoomDTO roomDTO)
        {
            Room room = roomDTO.ConvertToRoom();
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