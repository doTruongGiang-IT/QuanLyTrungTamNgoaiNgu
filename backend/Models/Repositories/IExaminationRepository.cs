using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public interface IExaminationRepository
    {
         IEnumerable<ExaminationDTO> GetAll();
         ExaminationDTO Get(int id);
         ExaminationDTO Create(ExaminationDTO examinationDTO);
         void Update(ExaminationDTO examinationDTO);
         void Delete(int id);
         ExaminationDTO GetCurrent();
    }
}