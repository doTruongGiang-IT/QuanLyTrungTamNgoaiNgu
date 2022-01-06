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
        public DbSet<Examination> examinations { get; set; }
        public DbSet<CandidateRoom> candidate_rooms { get; set; }
        public DbSet<SupervisorRoom> supervisor_rooms { get; set; }
        public DbSet<RegistrationForm> registration_forms { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Candidate>()
                .HasIndex(c => c.identification).IsUnique();
            modelBuilder.Entity<Candidate>()
                .HasIndex(c => c.email).IsUnique();
            modelBuilder.Entity<Candidate>()
                .HasIndex(c => c.phone).IsUnique();

            modelBuilder.Entity<CandidateRoom>()
                .HasIndex(cr => new {cr.candidate_id, cr.room_id}).IsUnique();

            modelBuilder.Entity<RegistrationForm>()
                .HasIndex(cr => new {cr.candidate_id, cr.examination_id}).IsUnique();

            modelBuilder.Entity<SupervisorRoom>()
                .HasIndex(cr => new {cr.supervisor_id, cr.room_id}).IsUnique();
        }
    }
}