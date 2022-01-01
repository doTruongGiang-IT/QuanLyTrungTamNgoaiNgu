using Microsoft.EntityFrameworkCore;

namespace backend.Models.Data
{
    public class QLTTNNContext : DbContext
    {
        public QLTTNNContext(DbContextOptions<QLTTNNContext> options): base(options)
        {

        }
        public DbSet<Candidate> candidates { get; set; }
        public DbSet<Supervisor> supervisors { get; set; }
        public DbSet<Room> rooms { get; set; }
    }
}