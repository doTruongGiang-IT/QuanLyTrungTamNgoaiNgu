using System.ComponentModel.DataAnnotations;

namespace backend.Models
{
    public class SupervisorRoom
    {
        [Key]
        public int id { get; set; }
        public int supervisor_id { get; set; }
        public int room_id { get; set; }
    }
}