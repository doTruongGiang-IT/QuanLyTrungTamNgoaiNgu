namespace backend.Models.Repositories
{
    public interface IExaminationRepository
    {
         IEnumerable<Examination> GetAll();
         Examination Get(int id);
         Examination Create(Examination examination);
         void Update(Examination examination);
         void Delete(int id);
    }
}