using backend.Models.Data;
using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public class ExaminationRepository : IExaminationRepository
    {
        private QLTTNNContext context;
        public ExaminationRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public ExaminationDTO Create(ExaminationDTO examinationDTO)
        {
            Examination examination = examinationDTO.ConvertToExamination();
            var result = this.context.examinations.Add(examination);
            this.context.SaveChanges();
            return examinationDTO;
;
        }

        public void Delete(int id)
        {
            var examination = this.context.examinations.Find(id);
            this.context.examinations.Remove(examination);
            this.context.SaveChanges();
        }

        public ExaminationDTO Get(int id)
        {
            ExaminationDTO examinationDTO = this.context.examinations.Find(id).ConvertToExaminationDTO();
            return examinationDTO;
        }

        public IEnumerable<ExaminationDTO> GetAll()
        {
            return this.context.examinations.ToList().ConvertToExaminationDTO();
        }

        public void Update(ExaminationDTO examinationDTO)
        {   
            Examination examination = examinationDTO.ConvertToExamination();
            this.context.examinations.Update(examination);
            this.context.SaveChanges();
        }

        public ExaminationDTO GetCurrent()
        {
            DateTime now = DateTime.Now;
            var firstDayOfMonth = DateTime.SpecifyKind(new DateTime(now.Year, now.Month, 1), DateTimeKind.Utc);
            var lastDayOfMonth = DateTime.SpecifyKind(firstDayOfMonth.AddMonths(1).AddDays(-1), DateTimeKind.Utc);
            Examination examination = this.context.examinations.SingleOrDefault(e => e.date >= firstDayOfMonth && e.date <= lastDayOfMonth);
            
            return examination.ConvertToExaminationDTO();
        }
    }
}