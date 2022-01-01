using backend.Models.Data;

namespace backend.Models.Repositories
{
    public class SupervisorRepository : ISupervisorRepository
    {

        private QLTTNNContext context;
        public SupervisorRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public IEnumerable<Supervisor> GetAll()
        {
            return this.context.supervisors.ToList();
        }
        public Supervisor Get(int id)
        {
            return this.context.supervisors.Find(id);
        }
        public Supervisor Create(Supervisor supervisor)
        {
            this.context.supervisors.Add(supervisor);
            this.context.SaveChanges();
            return supervisor;
        }
        public void Update(Supervisor supervisor)
        {
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