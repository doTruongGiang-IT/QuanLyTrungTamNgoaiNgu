namespace backend.Models.Repositories
{
    public interface ICandidateRepository
    {
        IEnumerable<Candidate> GetAll();
        Candidate Get(int id);
        Candidate Create(Candidate candidate);
        void Update(Candidate candidate);
        void Delete(int id);
    }
}