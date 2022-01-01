using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace backend.Models
{
    public class CandidateRoom
    {
        [Key]
        public int id { get; set; }
        public int candidate_id { get; set; }
        [ForeignKey("candidate_id")]
        public Candidate candidate { get; set; }
        public string candidate_no { get; set; }
        public int room_id { get; set; }
        [ForeignKey("room_id")]
        public Room room { get; set; }
        public float score_listening { get; set; }
        public float score_speaking { get; set; }
        public float score_writing { get; set; }
        public float score_reading { get; set; }
    }
}