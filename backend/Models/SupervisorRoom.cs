using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace backend.Models
{
    public class SupervisorRoom
    {
        [Key]
        public int id { get; set; }
        public int supervisor_id { get; set; }
        [ForeignKey("supervisor_id")]
        public Supervisor supervisor { get; set; }
        public int room_id { get; set; }
        [ForeignKey("room_id")]
        public Room room { get; set; }
    }
}