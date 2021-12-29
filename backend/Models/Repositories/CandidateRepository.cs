using backend.Models.Data;

namespace backend.Models.Repositories
{
    public class CandidateRepository : ICandidateRepository
    {
        private QLTTNNContext context;
        public CandidateRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public Candidate Create(Candidate candidate)
        {
            var result = this.context.candidates.Add(candidate);
            this.context.SaveChanges();
            return candidate;
;
        }

        public void Delete(int id)
        {
            var candidate = this.context.candidates.Find(id);
            this.context.candidates.Remove(candidate);
            this.context.SaveChanges();
        }

        public Candidate Get(int id)
        {
            return this.context.candidates.Find(id);
        }

        public IEnumerable<Candidate> GetAll()
        {
            return this.context.candidates.ToList();
        }

        public void Update(Candidate candidate)
        {   
            this.context.candidates.Update(candidate);
            this.context.SaveChanges();
        }
    }
}