namespace backend.Models.Repositories
{
    public interface ISupervisorRoomRepository
    {
         IEnumerable<SupervisorRoom> GetAll();
         SupervisorRoom Get(int id);
         SupervisorRoom Create(SupervisorRoom supervisorRoom);
         void Update(SupervisorRoom supervisorRoom);
         void Delete(int id);
    }
}