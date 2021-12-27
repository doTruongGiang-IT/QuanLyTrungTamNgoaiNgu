using Microsoft.EntityFrameworkCore;

namespace backend.Models.Data
{
    public class QLTTNNContext : DbContext, IQLTTNNContext
    {
        public QLTTNNContext(DbContextOptions<QLTTNNContext> options): base(options)
        {

        }
        public DbSet<Candidate> Candidates { get; set; }
    }
}