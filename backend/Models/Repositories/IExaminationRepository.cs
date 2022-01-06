using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public interface IExaminationRepository
    {
         IEnumerable<ExaminationDTO> GetAll();
         ExaminationDTO Get(int id);
         ExaminationDTO Create(ExaminationDTO examinationDTO);
         ExaminationDTO Update(ExaminationDTO examinationDTO);
         void UpdateArrange();
         void Delete(int id);
         ExaminationDTO GetCurrent();
    }
}