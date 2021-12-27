using Microsoft.EntityFrameworkCore;

namespace backend.Models.Data
{
    public interface IQLTTNNContext
    {
         DbSet<Candidate> Candidates { get; set; }
    }
}