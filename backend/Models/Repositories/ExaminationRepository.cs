using backend.Models.Data;

namespace backend.Models.Repositories
{
    public class ExaminationRepository : IExaminationRepository
    {
        private QLTTNNContext context;
        public ExaminationRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public Examination Create(Examination examination)
        {
            var result = this.context.examinations.Add(examination);
            this.context.SaveChanges();
            return examination;
;
        }

        public void Delete(int id)
        {
            var examination = this.context.examinations.Find(id);
            this.context.examinations.Remove(examination);
            this.context.SaveChanges();
        }

        public Examination Get(int id)
        {
            return this.context.examinations.Find(id);
        }

        public IEnumerable<Examination> GetAll()
        {
            return this.context.examinations.ToList();
        }

        public void Update(Examination examination)
        {   
            this.context.examinations.Update(examination);
            this.context.SaveChanges();
        }
    }
}