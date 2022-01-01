namespace backend.Models.Repositories
{
    public interface ISupervisorRepository
    {
         IEnumerable<Supervisor> GetAll();
         Supervisor Get(int id);
         Supervisor Create(Supervisor supervisor);
         void Update(Supervisor supervisor);
         void Delete(int id);
    }
}