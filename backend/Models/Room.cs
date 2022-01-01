using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace backend.Models
{
    public class Room
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public int examination_id { get; set; }
        [ForeignKey("examination_id")]
        public Examination Examination { get; set; }
        public string level { get; set; }
        public bool time { get; set; }

        public ICollection<CandidateRoom> candidateRooms { get; set; }

        public ICollection<SupervisorRoom> supervisorRooms { get; set; }
    }
}