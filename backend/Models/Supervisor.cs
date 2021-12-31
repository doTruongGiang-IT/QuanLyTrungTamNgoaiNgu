using System.ComponentModel.DataAnnotations;
// using System.Data.Entity.Core;

namespace backend.Models
{
    public class Supervisor
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public ICollection<SupervisorRoom> supervisorRooms { get; set; }
    }
}