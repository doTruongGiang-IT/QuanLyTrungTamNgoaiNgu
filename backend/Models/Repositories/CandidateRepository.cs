using backend.Models.Data;
using backend.Models.DTOs;

namespace backend.Models.Repositories
{
    public class CandidateRepository : ICandidateRepository
    {
        private QLTTNNContext context;
        public CandidateRepository(QLTTNNContext context)
        {
            this.context = context;
        }

        public CandidateDTO Create(CandidateDTO candidateDTO)
        {
            Candidate candidate = candidateDTO.ConvertToCandidate();
            var result = this.context.candidates.Add(candidate);
            this.context.SaveChanges();
            CandidateDTO candidateDTOReusult = result.Entity.ConvertToCandidateDTO();
            return candidateDTOReusult;
;
        }

        public void Delete(int id)
        {
            var candidate = this.context.candidates.Find(id);
            this.context.candidates.Remove(candidate);
            this.context.SaveChanges();
        }

        public CandidateDTO Get(int id)
        {
            CandidateDTO candidateDTO = this.context.candidates.Find(id).ConvertToCandidateDTO();
            return candidateDTO;
        }

        public IEnumerable<CandidateDTO> GetAll()
        {
            return this.context.candidates.ToList().ConvertToCandidateDTO();
        }

        public void Update(CandidateDTO candidateDTO)
        {   Candidate candidate = candidateDTO.ConvertToCandidate();
            this.context.candidates.Update(candidate);
            this.context.SaveChanges();
        }
    }
}