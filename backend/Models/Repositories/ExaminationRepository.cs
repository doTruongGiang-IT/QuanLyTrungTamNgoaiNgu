using backend.Models.Data;
using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public class ExaminationRepository : IExaminationRepository
    {
        public QLTTNNContext context;
        public ExaminationRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public ExaminationDTO Create(ExaminationDTO examinationDTO)
        {
            Examination examination = examinationDTO.ConvertToExamination();
            DateTime now = DateTime.Now;
            // var firstDayOfMonth = DateTime.SpecifyKind(new DateTime(now.Year, now.Month, 1), DateTimeKind.Utc);
            // var lastDayOfMonth = DateTime.SpecifyKind(firstDayOfMonth.AddMonths(1).AddDays(-1), DateTimeKind.Utc);
            if(DateTime.Compare(examination.date, now) < 0)
            {
                return null;
            }
            var examfirstDayOfMonth = DateTime.SpecifyKind(new DateTime(examination.date.Year, examination.date.Month, 1), DateTimeKind.Utc);
            var examlastDayOfMonth = DateTime.SpecifyKind(examfirstDayOfMonth.AddMonths(1).AddDays(-1), DateTimeKind.Utc);
            var checkExam = this.context.examinations.Where(e => e.date >= examfirstDayOfMonth && e.date <= examlastDayOfMonth).FirstOrDefault();
            if(checkExam != null)
            {

                return null;
            }
            var result = this.context.examinations.Add(examination);
            this.context.SaveChanges();
            ExaminationDTO examinationDTOResult = result.Entity.ConvertToExaminationDTO();
            return examinationDTOResult;
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