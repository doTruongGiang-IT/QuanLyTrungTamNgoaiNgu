namespace backend.Models.Repositories
{
    public interface IRoomRepository
    {
         IEnumerable<Room> GetAll();
         Room Get(int id);
         Room Create(Room room);
         void Update(Room room);
         void Delete(int id);
    }
}