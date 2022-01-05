using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace backend.Models
{

    public class Candidate
    {
        [Key]
        public int id { get; set; }
        public string identification { get; set; }
        public DateTime issue_date { get; set; }
        public string issue_place { get; set; }
        public string email { get; set; }
        public string first_name { get; set; }
        public string last_name { get; set; }
        public string gender { get; set; }
        public DateTime date_of_birth { get; set; }
        public string place_of_birth { get; set; }
        public string phone { get; set; }

        // public ICollection<RegistrationForm> registrationForms { get; set; }

        // public ICollection<CandidateRoom> candidateRooms { get; set; }
    }
}