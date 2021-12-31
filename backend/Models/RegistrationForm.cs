using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace backend.Models
{
    public class RegistrationForm
    {
        [Key]
        public int id { get; set; }
        public int candidate_id { get; set; }
        [ForeignKey("candidate_id")]
        public Candidate candidate { get; set;}
        public int examination_id { get; set; }
        [ForeignKey("examination_id")]
        public Examination examination { get; set; }
        public string level { get; set; }
        public bool status { get; set; }
    }
}